package com.huayun.cms.controller;


import com.huayun.cms.entity.Result;
import com.huayun.cms.entity.Status;
import com.huayun.cms.service.ITbDataSyncService;
import com.huayun.cms.service.impl.TbLoginInfoServiceImpl;
import com.huayun.cms.service.impl.TbUserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-07-27
 */
@RestController
@RequestMapping("/dataSync")
@CrossOrigin
public class TbDataSyncController {
    @Autowired
    private ITbDataSyncService dataSyncService;

    @Autowired
    private TbLoginInfoServiceImpl loginInfoService;

    @Autowired
    private TbUserInfoServiceImpl userInfoService;

    @GetMapping("/selectList")
    public Result selectList(Map<String,Object> map) {
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), dataSyncService.selectList());
    }

    @PostMapping("/syncUserInfo")
    @Transactional
    public Result syncUserInfo(@RequestBody Map<String, Object> map) {
        try {
            loginInfoService.syncUserLoginInfo();
            userInfoService.syncUserInfo();
        } catch (Exception e) {
            return new Result(Status.ERROR.getCode(), Status.ERROR.getMessage());
        }
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage());
    }

    @PostMapping("/replaceSyncUserInfo")
    public Result replaceSyncUserInfo(@RequestBody Map<String, Object> map) {
        int i = dataSyncService.replaceSyncUserInfo(map);
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage());
    }

    @PostMapping("/deleteSyncUserInfo")
    public Result deleteSyncUserInfo(@RequestBody Map<String, Object> map) {
        int i = dataSyncService.deleteSyncUserInfo(map);
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage());
    }
}
