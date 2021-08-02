package com.huayun.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huayun.cms.entity.*;
import com.huayun.cms.mapper.TbLoginInfoMapper;
import com.huayun.cms.service.ITbDataSyncService;
import com.huayun.cms.service.ITbLoginInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayun.cms.slave1Service.IUserInfoNanoqSzService;
import com.huayun.cms.slave1Service.impl.UserLoginInfoNanoqSzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public int syncUserLoginInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowTime = LocalDate.now().format(formatter);
        //获取要同步的数据库
        TbDataSync nanoQ = dataSyncService.getById("NanoQ");
        //获取要同步数据库的信息
        List<UserLoginInfoNanoqSz> userLoginInfoNanoqSzs = service.selectList(new HashMap<String, Object>() {{
            put("nowTime", nowTime);
        }});
//        List<UserInfoNanoqSz> userInfoNanoqSzs = service.selectList(null);
        List<TbUserInfo> userInfoList=new ArrayList<>();
        for (UserLoginInfoNanoqSz userLoginInfoNanoqSz : userLoginInfoNanoqSzs) {
//            Integer expireDate = userLoginInfoNanoqSzs.getExpireDate();
//            int day=expireDate%100;
//            int month=expireDate/100%100;
//            int year=expireDate/10000;
//            LocalDate of = LocalDate.of(year, Month.of(month), day);
//            String endDate = of.format(formatter);
//            TbUserInfo userInfo=new TbUserInfo();
//            userInfo.setSysName(nanoQ.getSysName())
//                    .setUserName(userInfoNanoqSz.getUserName())
//                    .setUserPassword(userInfoNanoqSz.getUserPwd())
//                    .setCenter(nanoQ.getCenter())
//                    .setUserStatus(userInfoNanoqSz.getUserStatus())
//                    .setUserFullName(userInfoNanoqSz.getInvestorName())
//                    .setUserIp("")
//                    .setMarketPermission(userInfoNanoqSz.getMarketPermission())
//                    .setDataPermission(2)
//                    .setStartDate(userInfoNanoqSz.getCreateTime().format(formatter))
//                    .setEndDate(endDate);
//            userInfoList.add(userInfo);
        }
        return /*tbLoginInfoMapper.replaceUserInfo(userInfoList)*/0;
    }
}
