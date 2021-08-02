package com.huayun.cms.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TbLoginInfoServiceImplTest {
@Autowired
private TbLoginInfoServiceImpl service;
    @Test
    void syncUserLoginInfo() {
        service.syncUserLoginInfo();
    }
}