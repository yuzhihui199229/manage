package com.huayun.cms.service.impl;

import com.huayun.cms.service.ITbUserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TbUserInfoServiceImplTest {
    @Autowired
    private ITbUserInfoService service;

    @Test
    void syncUserInfo() {
        service.syncUserInfo();
    }
}