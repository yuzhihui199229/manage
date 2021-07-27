package com.huayun.cms.service;

import com.huayun.cms.entity.TbSysUsers;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
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
    List<TbSysUsers> selectList(Map<String, Object> map);
}
