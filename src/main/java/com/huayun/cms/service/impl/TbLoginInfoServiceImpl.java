package com.huayun.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huayun.cms.entity.TbLoginInfo;
import com.huayun.cms.mapper.TbLoginInfoMapper;
import com.huayun.cms.service.ITbLoginInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2021-07-20
 */
@Service
public class TbLoginInfoServiceImpl extends ServiceImpl<TbLoginInfoMapper, TbLoginInfo> implements ITbLoginInfoService {
    @Autowired
    private TbLoginInfoMapper tbLoginInfoMapper;

    public List<TbLoginInfo> selectList(Map<String, Object> map) {
        LambdaQueryWrapper<TbLoginInfo> wrapper = new LambdaQueryWrapper();
        Object sysName = map.get("sysName");
        if (sysName != null && !"".equals(sysName))
            wrapper.eq(TbLoginInfo::getSysName, sysName);
        Object center = map.get("center");
        if (center != null && !"".equals(center))
            wrapper.eq(TbLoginInfo::getCenter, center);
        Object loginStatus = map.get("loginStatus");
        if (loginStatus != null && !"".equals(loginStatus))
            wrapper.eq(TbLoginInfo::getLoginStatus, loginStatus);
        Object loginDate = map.get("loginDate");
        if (loginDate != null && !"".equals(loginDate))
            wrapper.eq(TbLoginInfo::getLoginDate, loginDate);
        return tbLoginInfoMapper.selectList(wrapper);
    }
}
