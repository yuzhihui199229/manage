package com.huayun.cms.slave1Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayun.cms.entity.UserLoginInfoNanoqSz;
import com.huayun.cms.slave1Mapper.UserLoginInfoNanoqSzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-31
 */
@Service
public class UserLoginInfoNanoqSzServiceImpl extends ServiceImpl<UserLoginInfoNanoqSzMapper, UserLoginInfoNanoqSz> implements IService<UserLoginInfoNanoqSz> {
    @Autowired
    private UserLoginInfoNanoqSzMapper mapper;

    public List<UserLoginInfoNanoqSz> selectList(Map<String, Object> map) {
        QueryWrapper<UserLoginInfoNanoqSz> wrapper = new QueryWrapper<>();
        if (map != null) {
            String nowTime = (String) map.get("nowTime");
            if (StringUtils.hasLength(nowTime))
                wrapper.eq("DATE_FORMAT(LOGIN_TIME,'%Y-%m-%d')", nowTime);
        }
        return mapper.selectList(wrapper);
    }
}
