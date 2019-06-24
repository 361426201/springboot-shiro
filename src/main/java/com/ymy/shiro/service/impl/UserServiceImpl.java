package com.ymy.shiro.service.impl;

import com.ymy.shiro.entity.User;
import com.ymy.shiro.mapper.UserMapper;
import com.ymy.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
