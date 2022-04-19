package com.example.lingjing.service;

import com.example.lingjing.bean.UserBean;
import com.example.lingjing.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    // 查
    public UserBean getUser(Integer id) {
        return userMapper.getUser(id);
    }

    // 增
    public Integer addUser(Map body) {
        return userMapper.addUser(body);
    }

    // 删
    public Integer deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    // 改
    public Integer editUser(Map body) {
        return userMapper.editUser(body);
    }
}
