package com.huayun.cms.service.impl;

import com.huayun.cms.entity.TbDataSync;
import com.huayun.cms.mapper.TbDataSyncMapper;
import com.huayun.cms.service.ITbDataSyncService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
        return tbDataSyncMapper.selectList(null);
    }

    public int syncUserInfo(Map<String, Object> map) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        map.put("date",date);
        return tbDataSyncMapper.syncUserInfo(map);
    }
}
