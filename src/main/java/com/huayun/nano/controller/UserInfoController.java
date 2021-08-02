package com.huayun.nano.controller;


import com.huayun.cms.entity.Result;
import com.huayun.cms.entity.Status;
import com.huayun.nano.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-02
 */
@RestController
@RequestMapping("/nano/userInfo")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/selectList")
    public Result selectList() {
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(),userInfoService.list());
    }
}
