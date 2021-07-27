package com.huayun.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huayun.cms.entity.TbUserInfo;
import com.huayun.cms.entity.UserStatus;
import com.huayun.cms.mapper.TbUserInfoMapper;
import com.huayun.cms.service.ITbUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
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
public class TbUserInfoServiceImpl extends ServiceImpl<TbUserInfoMapper, TbUserInfo> implements ITbUserInfoService {
    @Autowired
    private TbUserInfoMapper tbUserInfoMapper;

    @Transactional
    public List<TbUserInfo> selectList(Map<String, Object> map) {
        LambdaQueryWrapper<TbUserInfo> wrapper = new LambdaQueryWrapper<>();
        Object marketPermission = map.get("marketPermission");
        if (marketPermission != null && !"".equals(marketPermission))
            wrapper.eq(TbUserInfo::getMarketPermission, marketPermission);
        Object dataPermission = map.get("dataPermission");
        if (dataPermission != null && !"".equals(dataPermission))
            wrapper.eq(TbUserInfo::getDataPermission, dataPermission);
        Object userFullName = map.get("userFullName");
        if (userFullName != null && !"".equals(userFullName))
            wrapper.like(TbUserInfo::getUserFullName, map.get("userFullName"));
        Object startDate = map.get("startDate");
        Object endDate = map.get("endDate");
        Object userStatus = map.get("userStatus");
        if (userStatus != null && !"".equals(userStatus)) {
            wrapper.eq(TbUserInfo::getUserStatus, userStatus);
            if ("0".equals(userStatus) && endDate != null && !"".equals(endDate)) {
                wrapper.gt(TbUserInfo::getEndDate, endDate);
                wrapper.lt(TbUserInfo::getStartDate, endDate);
            } else if ("1".equals(userStatus)) {
                if (endDate != null && !"".equals(endDate))
                    wrapper.le(TbUserInfo::getEndDate, endDate);
                if (startDate != null && !"".equals(startDate))
                    wrapper.ge(TbUserInfo::getEndDate, startDate);
            } else if ("2".equals(userStatus)) {
                if (endDate != null && !"".equals(endDate))
                    wrapper.le(TbUserInfo::getStartDate, endDate);
                if (startDate != null && !"".equals(startDate))
                    wrapper.ge(TbUserInfo::getStartDate, startDate);
            }
        }

        return tbUserInfoMapper.selectList(wrapper);
    }

    @Override
    public List<Map<String, Object>> userInfo(Map<String, Object> map) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<UserStatus> addUserCount = tbUserInfoMapper.addUserCount(map);
        List<UserStatus> cancelUserCount = tbUserInfoMapper.cancelUserCount(map);
        List<UserStatus> currentUserCount = tbUserInfoMapper.currentUserCount(map);
        for (int i = 0; i < addUserCount.size(); i++) {
            Map<String,Object> userInfoMap=new HashMap<>();
            userInfoMap.put("date",addUserCount.get(i).getDate());
            userInfoMap.put("addUserCount",addUserCount.get(i).getCount());
            if (cancelUserCount.get(i).getDate().equals(userInfoMap.get("date"))) {
                userInfoMap.put("cancelUserCount", cancelUserCount.get(i).getCount());
            } else {
                userInfoMap.put("cancelUserCount", 0);
            }
            if (currentUserCount.get(i).getDate().equals(userInfoMap.get("date"))) {
                userInfoMap.put("currentUserCount", currentUserCount.get(i).getCount());
            } else {
                userInfoMap.put("currentUserCount", 0);
            }
            resultList.add(userInfoMap);
        }
        return resultList;
    }
}
