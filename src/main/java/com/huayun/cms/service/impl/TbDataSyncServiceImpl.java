package com.huayun.cms.service.impl;

import com.huayun.cms.entity.TbDataSync;
import com.huayun.cms.mapper.TbDataSyncMapper;
import com.huayun.cms.service.ITbDataSyncService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
