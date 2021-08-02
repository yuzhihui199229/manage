package com.huayun.cms.mapper;

import com.huayun.cms.entity.TbDataSync;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzh
 * @since 2021-07-27
 */
public interface TbDataSyncMapper extends BaseMapper<TbDataSync> {
    int syncUserInfo(Map<String,Object> map);

    int replaceSyncUserInfo(Map<String,Object> map);

    int deleteSyncUserInfo(Map<String,Object> map);
}
