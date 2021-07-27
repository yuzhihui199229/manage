package com.huayun.cms.controller;


import com.huayun.cms.entity.Result;
import com.huayun.cms.entity.Status;
import com.huayun.cms.service.ITbUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/tbUserInfo")
@CrossOrigin
public class TbUserInfoController{
    @Autowired
    private ITbUserInfoService tbUserInfoService;

    @PostMapping("/selectList")
    public Result selectList(@RequestBody Map<String, Object> map) {
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), tbUserInfoService.selectList(map));
    }

    @PostMapping("userInfo")
    public Result userInfo(@RequestBody Map<String, Object> map) {
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(),tbUserInfoService.userInfo(map));
    }
}
