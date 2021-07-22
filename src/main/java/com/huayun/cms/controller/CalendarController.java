package com.huayun.cms.controller;


import com.huayun.cms.entity.Result;
import com.huayun.cms.entity.Status;
import com.huayun.cms.entity.UserStatus;
import com.huayun.cms.service.ICalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-07-21
 */
@RestController
@RequestMapping("calendar")
@CrossOrigin
public class CalendarController {
    @Autowired
    private ICalendarService calendarService;

    @PostMapping("userInfo")
    @Transactional
    public Result userInfo(@RequestBody Map<String, Object> map) {
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(),calendarService.userInfo(map));
    }
}
