package com.ymy.shiro.utils;

import com.alibaba.fastjson.JSON;
import com.ymy.shiro.bo.UserInfo;
import com.ymy.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Session session = SecurityUtils.getSubject().getSession();
        //查询用户的权限
        UserInfo userInfo = (UserInfo) session.getAttribute("token");
        log.info("本用户信息：{}", JSON.toJSONString(userInfo));
        log.info("本用户权限为:" + userInfo.getRoles());
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(userInfo.getPermissions());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户名
        String name = authenticationToken.getPrincipal().toString();
        //获取密码
        String password = new String((char[]) authenticationToken.getCredentials());
        UserInfo user = userService.getUserByName(name,password);
        log.info("user==========>"+user);
        if (user == null) {
            //这里返回后会报出对应异常
            return (AuthenticationInfo) new UnknownAccountException();
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            //session中不需要保存密码
            user.setPassword("");
            //将用户信息放入session中
           // SecurityUtils.getSubject().getSession().setAttribute("token", user);



            return simpleAuthenticationInfo;
        }
    }
}
