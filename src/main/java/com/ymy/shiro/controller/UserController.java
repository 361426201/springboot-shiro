package com.ymy.shiro.controller;

import com.ymy.shiro.entity.User;
import com.ymy.shiro.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@Api(tags = "用户")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        User user = userService.getUserByName("zhangsan");
        System.out.println(user);
        return "hello";
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        subject.login(token);
        System.out.println("登录成功");
        return "登陆成功";
    }
}
