package com.ymy.shiro.service.impl;

import com.ymy.shiro.bo.UserInfo;
import com.ymy.shiro.entity.User;
import com.ymy.shiro.mapper.PermissionMapper;
import com.ymy.shiro.mapper.RoleMapper;
import com.ymy.shiro.mapper.UserMapper;
import com.ymy.shiro.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public UserInfo getUserByName(String name, String pwd) {
        User user = userMapper.getUserByName(name, pwd);
        if(null == user){
            return null ;
        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user,userInfo);
        //设置角色
        userInfo.setRoles(roleMapper.getRoleByUserId(user.getId()));
        //添加权限
        if(null != userInfo.getRoles()){
            userInfo.getRoles().forEach(role -> userInfo.setPermissions(permissionMapper.getListByRoleId(role.getId())));
        }
        return userInfo;
    }
}
