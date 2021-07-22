package com.huayun.cms.controller;


import com.huayun.cms.entity.Result;
import com.huayun.cms.entity.Status;
import com.huayun.cms.service.ITbLoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/tbLoginInfo")
@CrossOrigin
public class TbLoginInfoController {
    @Autowired
    private ITbLoginInfoService tbLoginInfoService;

    @PostMapping("/selectList")
    public Result selectList(@RequestBody Map<String, Object> map) {
        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), tbLoginInfoService.selectList(map));
    }
}
