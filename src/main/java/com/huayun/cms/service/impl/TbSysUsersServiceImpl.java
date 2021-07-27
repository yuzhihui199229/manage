package com.huayun.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huayun.cms.entity.TbSysUsers;
import com.huayun.cms.mapper.TbSysUsersMapper;
import com.huayun.cms.service.ITbSysUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayun.cms.utils.CodeDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-07-21
 */
@Service
public class TbSysUsersServiceImpl extends ServiceImpl<TbSysUsersMapper, TbSysUsers> implements ITbSysUsersService {
    @Autowired
    private TbSysUsersMapper tbSysUsersMapper;

    @Override
    public List<TbSysUsers> selectList(Map<String, Object> map) {
        LambdaQueryWrapper<TbSysUsers> wrapper = new LambdaQueryWrapper();
        String password = CodeDigest.encryption((String) map.get("userPassword"));
        wrapper.select(TbSysUsers::getUserRole)
                .eq(TbSysUsers::getUserName, map.get("userName"))
                .eq(TbSysUsers::getUserPassword, password);
        return tbSysUsersMapper.selectList(wrapper);
    }
}
