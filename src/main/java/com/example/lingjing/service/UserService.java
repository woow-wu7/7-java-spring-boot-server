package com.example.lingjing.service;

import com.example.lingjing.bean.UserBean;
import com.example.lingjing.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public UserBean getUser(Integer id) {
        return userMapper.getUser(id);
    }
}
