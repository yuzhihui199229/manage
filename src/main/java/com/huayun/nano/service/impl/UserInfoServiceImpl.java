package com.huayun.nano.service.impl;

import com.huayun.nano.entity.UserInfo;
import com.huayun.nano.mapper.UserInfoMapper;
import com.huayun.nano.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-08-02
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
