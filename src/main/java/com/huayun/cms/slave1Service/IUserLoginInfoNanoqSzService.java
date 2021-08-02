package com.huayun.cms.slave1Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huayun.cms.entity.UserLoginInfoNanoqSz;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-31
 */
public interface IUserLoginInfoNanoqSzService extends IService<UserLoginInfoNanoqSz> {
    List<UserLoginInfoNanoqSz> selectList(Map<String, Object> map);
}
