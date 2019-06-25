package com.ymy.shiro.controller;

import com.ymy.shiro.bo.UserInfo;
import com.ymy.shiro.entity.User;
import com.ymy.shiro.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "用户")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @RequiresPermissions("select")
    public String hello() {
        log.info("你有权限");
        /*UserInfo user = userService.getUserByName("zhangsan", "123456");
        System.out.println(user);*/
        return "hello";
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            //登录校验
            subject.login(token);

        }catch (IncorrectCredentialsException | UnknownAccountException e){//捕获用户名或这密码不正确的异常
            log.info("用户名或密码错误");
            return "用户名或密码错误";
        }
        System.out.println("登录成功");
        return "登陆成功";
    }


    @ApiOperation(value = "登录")
    @RequiresPermissions("select")
    @RequestMapping(value = "login1", method = RequestMethod.POST)
    public String login1(@RequestBody User user) {
        System.out.println("登录成功");
        return "登陆成功";
    }
}
