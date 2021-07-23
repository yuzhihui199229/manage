package com.huayun.cms.controller;


import com.huayun.cms.entity.Result;
import com.huayun.cms.entity.Status;
import com.huayun.cms.service.ITbLoginInfoService;
import com.huayun.cms.service.ITbSysUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("tbSysUsers")
@CrossOrigin
public class TbSysUsersController {
    @Autowired
    private ITbSysUsersService tbSysUsersService;

    @PostMapping("/selectList")
    public Result selectList(@RequestBody Map<String, Object> map) {
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), tbSysUsersService.selectList(map));
    }
}