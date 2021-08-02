package com.huayun.cms.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huayun.cms.entity.TbDataSync;
import com.huayun.cms.entity.TbSysUsers;
import com.huayun.cms.mapper.TbDataSyncMapper;
import com.huayun.cms.service.ITbDataSyncService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayun.cms.utils.EncodeBasePwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-27
 */
@Service
public class TbDataSyncServiceImpl extends ServiceImpl<TbDataSyncMapper, TbDataSync> implements ITbDataSyncService {
    @Autowired
    private TbDataSyncMapper tbDataSyncMapper;

    public List<TbDataSync> selectList() {
        /*LambdaQueryWrapper<TbDataSync> wrapper = new LambdaQueryWrapper();
        wrapper.select(TbDataSync::getCenter,TbDataSync::getSysName,TbDataSync::getSyncDate,
                TbDataSync::getSyncTime,TbDataSync::getDbUser,TbDataSync::getDbConn);*/
        return tbDataSyncMapper.selectList(null);
    }

    public int syncUserInfo(Map<String, Object> map) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        map.put("date",date);
        return tbDataSyncMapper.syncUserInfo(map);
    }


    public int replaceSyncUserInfo(Map<String, Object> map) {
       /* String date = map.get("dbPwd").toString();
        String rstruts = EncodeBasePwd.getEecode(date);
        map.put("dbPwd",rstruts);*/
        return tbDataSyncMapper.replaceSyncUserInfo(map);
    }

    public int deleteSyncUserInfo(Map<String, Object> map) {
        return tbDataSyncMapper.deleteSyncUserInfo(map);
    }
}
