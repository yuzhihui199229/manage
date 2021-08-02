package com.huayun.cms.slave1Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayun.cms.entity.UserInfoNanoqSz;
import com.huayun.cms.slave1Mapper.UserInfoNanoqSzMapper;
import com.huayun.cms.slave1Service.IUserInfoNanoqSzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-31
 */
@Service
public class UserInfoNanoqSzServiceImpl extends ServiceImpl<UserInfoNanoqSzMapper, UserInfoNanoqSz> implements IUserInfoNanoqSzService {
    @Autowired
    private UserInfoNanoqSzMapper mapper;

    @Override
    public List<UserInfoNanoqSz> selectList(Map<String, Object> map) {
//        LambdaQueryWrapper<UserInfoNanoqSz> wrapper = new LambdaQueryWrapper<>();
        QueryWrapper<UserInfoNanoqSz> wrapper = new QueryWrapper<>();

        if (map != null) {
            String nowTime = (String) map.get("nowTime");
            if (StringUtils.hasLength(nowTime))
                wrapper.eq("DATE_FORMAT(CREATE_TIME,'%Y-%m-%d')", nowTime);
        }
        return mapper.selectList(wrapper);
    }
}
