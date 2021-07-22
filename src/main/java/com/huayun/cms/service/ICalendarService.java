package com.huayun.cms.service;

import com.huayun.cms.entity.Calendar;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayun.cms.entity.UserStatus;

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
public interface ICalendarService extends IService<Calendar> {
    List<Map<String, Object>> userInfo(Map<String, Object> map);
}
