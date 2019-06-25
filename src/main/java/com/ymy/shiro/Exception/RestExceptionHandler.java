package com.ymy.shiro.Exception;

import com.ymy.shiro.bo.BoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @ClassName GlobalExceptionHandler
 * @Description 统一异常处理
 * @Author zhaohui
 * @Date 2018/8/6 16:38
 * @Version 1.0
 */

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {


    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = Exception.class)
    public BoUtil handleRRException(Exception e){
        //log.error("发生错误："+e.getMessage());
        e.printStackTrace();
        BoUtil result = BoUtil.getDefaultFailed();
        result.setCode(-2);
        if(e instanceof UnauthenticatedException){
            result.setMessage("请先登录");
        }else if(e instanceof UnauthorizedException){
            result.setMessage("没有访问此接口的权限");
        }else{
            result.setMessage("网络错误");
        }
        //result.setMessage("网络错误");
        return result;
    }






}

