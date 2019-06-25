package com.ymy.shiro.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: FSNH_Manager
 * @description:
 * @author: yaomaoyang
 * @create: 2019-06-25 09:54
 **/
@Data
public class Role {

    private Integer id;

    private String role;

    private List<Permission> permissions;
}
