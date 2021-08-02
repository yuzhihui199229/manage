package com.huayun.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.huayun.cms.entity.*;
import com.huayun.cms.mapper.TbDataSyncMapper;
import com.huayun.cms.mapper.TbLoginInfoMapper;
import com.huayun.cms.service.ITbDataSyncService;
import com.huayun.cms.service.ITbLoginInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayun.cms.slave1Service.IUserInfoNanoqSzService;
import com.huayun.cms.slave1Service.impl.UserLoginInfoNanoqSzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-20
 */
@Service
public class TbLoginInfoServiceImpl extends ServiceImpl<TbLoginInfoMapper, TbLoginInfo> implements ITbLoginInfoService {
    @Autowired
    private TbLoginInfoMapper tbLoginInfoMapper;

    public List<TbLoginInfo> selectList(Map<String, Object> map) {
        LambdaQueryWrapper<TbLoginInfo> wrapper = new LambdaQueryWrapper();
        Object sysName = map.get("sysName");
        if (sysName != null && !"".equals(sysName))
            wrapper.eq(TbLoginInfo::getSysName, sysName);
        Object center = map.get("center");
        if (center != null && !"".equals(center))
            wrapper.eq(TbLoginInfo::getCenter, center);
        Object loginStatus = map.get("loginStatus");
        if (loginStatus != null && !"".equals(loginStatus))
            wrapper.eq(TbLoginInfo::getLoginStatus, loginStatus);
        Object loginDate = map.get("loginDate");
        if (loginDate != null && !"".equals(loginDate))
            wrapper.eq(TbLoginInfo::getLoginDate, loginDate);
        Object userName = map.get("userName");
        if (userName != null && !"".equals(userName))
            wrapper.eq(TbLoginInfo::getUserName, userName);
        return tbLoginInfoMapper.selectList(wrapper);
    }

    @Autowired
    private UserLoginInfoNanoqSzServiceImpl service;

    @Autowired
    private ITbDataSyncService dataSyncService;

    @Autowired
    private TbDataSyncMapper tbDataSyncMapper;

    @Async
    @Scheduled(cron = "0 0 20 * * ?")
    @Override
    public void syncUserLoginInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //当前日期
        String nowTime = now.format(formatter);
        //当前时间
        String time = now.format(formatterTime);
        //获取要同步的数据库
        TbDataSync nanoQ = dataSyncService.getById("NanoQ");
        //获取要同步数据库的信息
        List<UserLoginInfoNanoqSz> userLoginInfoNanoqSzs = service.selectList(new HashMap<String, Object>() {{
            put("nowTime", nowTime);
        }});
        List<TbLoginInfo> userLoginInfoList=new ArrayList<>();
        for (UserLoginInfoNanoqSz userLoginInfoNanoqSz : userLoginInfoNanoqSzs) {
            String clientInfo = userLoginInfoNanoqSz.getClientInfo();
            String loginIp="";
            if (StringUtils.hasLength(clientInfo)) {
                String[] strings = clientInfo.split("\\|");
                if (strings.length > 2) {
                    loginIp=strings[2];
                }
            }
            TbLoginInfo loginInfo=new TbLoginInfo();
            loginInfo.setSysName(nanoQ.getSysName())
                    .setLoginId(userLoginInfoNanoqSz.getLoginId())
                    .setCenter(nanoQ.getCenter())
                    .setUserName(userLoginInfoNanoqSz.getUserName())
                    .setLoginStatus(userLoginInfoNanoqSz.getLoginStatus())
                    .setLoginDate(userLoginInfoNanoqSz.getLoginTime().format(formatter))
                    .setLoginTime(userLoginInfoNanoqSz.getLoginTime().format(formatterTime))
                    .setLoginSession(userLoginInfoNanoqSz.getSessionId().intValue())
                    .setLoginIp(loginIp)
                    .setServerIp(userLoginInfoNanoqSz.getAccessIp())
                    .setRemark(userLoginInfoNanoqSz.getRemark());
            userLoginInfoList.add(loginInfo);
        }

        TbDataSync dataSync=new TbDataSync();
        dataSync.setSysName(nanoQ.getSysName())
                .setCenter(nanoQ.getCenter())
                .setSyncDate(nowTime)
                .setSyncTime(time);
        tbDataSyncMapper.updateById(dataSync);
        tbLoginInfoMapper.replaceUserLoginInfo(userLoginInfoList);
    }
}
