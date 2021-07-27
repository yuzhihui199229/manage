package com.huayun.cms.controller;


import com.huayun.cms.entity.Result;
import com.huayun.cms.entity.Status;
import com.huayun.cms.service.ITbDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}
