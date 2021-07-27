package com.huayun.cms.service;

import com.huayun.cms.entity.TbDataSync;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-27
 */
public interface ITbDataSyncService extends IService<TbDataSync> {
    public List<TbDataSync> selectList();
}
