package com.ymy.shiro.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户登录信息")
public class User {

    @ApiModelProperty(name = "id")
    private Integer id;

    @ApiModelProperty(name = "用户名")
    private String userName;

    @ApiModelProperty(name = "密码")
    private String password;
}
