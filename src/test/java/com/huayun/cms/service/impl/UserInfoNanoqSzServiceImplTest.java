package com.huayun.cms.service.impl;

import com.huayun.cms.entity.UserInfoNanoqSz;
import com.huayun.cms.slave1Service.IUserInfoNanoqSzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UserInfoNanoqSzServiceImplTest {

    @Autowired
    private IUserInfoNanoqSzService service;

    @Test
    void selectList() {
        Map<String,Object> map= new HashMap<>();
        List<UserInfoNanoqSz> userInfoNanoqSzs = service.selectList(map);
        for (UserInfoNanoqSz userInfoNanoqSz : userInfoNanoqSzs) {
            System.out.println(userInfoNanoqSz.toString());
        }
    }

    @Test
    void timeTest() {
        LocalDate of = LocalDate.of(2020, 1, 1);
        String date = of.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);
    }

}