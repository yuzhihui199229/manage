package com.huayun.cms.service.impl;

import com.huayun.cms.entity.Calendar;
import com.huayun.cms.entity.UserStatus;
import com.huayun.cms.mapper.CalendarMapper;
import com.huayun.cms.service.ICalendarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @since 2021-07-21
 */
@Service
public class CalendarServiceImpl extends ServiceImpl<CalendarMapper, Calendar> implements ICalendarService {
    @Autowired
    private CalendarMapper calendarMapper;

    @Override
    @Transactional
    public List<Map<String, Object>> userInfo(Map<String, Object> map) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<UserStatus> addUserCount = calendarMapper.addUserCount(map);
        List<UserStatus> cancelUserCount = calendarMapper.cancelUserCount(map);
        List<UserStatus> currentUserCount = calendarMapper.currentUserCount(map);
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
