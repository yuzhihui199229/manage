package com.huayun.cms.service;

import com.huayun.cms.entity.TbUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-20
 */
public interface ITbUserInfoService extends IService<TbUserInfo> {
    List<TbUserInfo> selectList(Map<String,Object> map);
}
