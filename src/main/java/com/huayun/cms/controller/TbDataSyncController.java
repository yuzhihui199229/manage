package com.huayun.cms.controller;


import com.huayun.cms.entity.Result;
import com.huayun.cms.entity.Status;
import com.huayun.cms.service.ITbDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/selectList")
    public Result selectList() {
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), dataSyncService.selectList());
    }

    @PostMapping("/syncUserInfo")
    public Result syncUserInfo(@RequestBody Map<String, Object> map) {
        int i = dataSyncService.syncUserInfo(map);
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage());
    }
}
