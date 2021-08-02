package com.huayun.cms.mapper;

import com.huayun.cms.ManageApplication;
import com.huayun.cms.entity.TbLoginInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzh
 * @since 2021-07-20
 */
public interface TbLoginInfoMapper extends BaseMapper<TbLoginInfo> {
int replaceUserLoginInfo(Map<String,Object> map);
}
