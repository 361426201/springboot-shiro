package com.ymy.shiro.service;

import com.ymy.shiro.bo.UserInfo;
import com.ymy.shiro.entity.User;

public interface UserService {

    UserInfo getUserByName(String name, String pwd);
}
