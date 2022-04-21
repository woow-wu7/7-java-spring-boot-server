package com.example.lingjing.controller;

import com.example.lingjing.bean.UserMybatisPlusBean;
import com.example.lingjing.service.UserMybatisPlusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserMybatisPlusControllerLog {

    @Autowired
    UserMybatisPlusService userMybatisPlusService;

    // 主要测试
    // - 1. mybatis-plus service相关
    // - 2. mybatis-plus 日志
    @GetMapping("/user-list")
    public List<UserMybatisPlusBean> getUserList() {
        List<UserMybatisPlusBean> list = userMybatisPlusService.list();
        log.info("list => {}", list);

        return list;
    }
}
