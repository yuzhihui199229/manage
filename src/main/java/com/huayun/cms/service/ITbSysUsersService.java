package com.huayun.cms.service;

import com.huayun.cms.entity.TbSysUsers;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-21
 */
public interface ITbSysUsersService extends IService<TbSysUsers> {
    TbSysUsers login(Map<String, Object> map);
}
