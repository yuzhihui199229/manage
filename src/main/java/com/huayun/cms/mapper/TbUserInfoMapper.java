package com.huayun.cms.mapper;

import com.huayun.cms.entity.TbUserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayun.cms.entity.UserStatus;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzh
 * @since 2021-07-20
 */
public interface TbUserInfoMapper extends BaseMapper<TbUserInfo> {
    List<UserStatus> addUserCount(Map<String, Object> map);

    List<UserStatus> cancelUserCount(Map<String, Object> map);

    List<UserStatus> currentUserCount(Map<String, Object> map);
}
