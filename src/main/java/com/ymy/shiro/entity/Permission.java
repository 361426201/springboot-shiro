package com.ymy.shiro.entity;

import lombok.Data;

/**
 * @program: FSNH_Manager
 * @description:
 * @author: yaomoayang
 * @create: 2019-06-25 09:54
 **/
@Data
public class Permission {

    private Integer id;

    private String permission;

    private Integer roleId;
}
