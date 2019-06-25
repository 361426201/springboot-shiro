package com.ymy.shiro.bo;

import com.ymy.shiro.entity.Permission;
import com.ymy.shiro.entity.Role;
import lombok.Data;

import java.util.List;

/**
 * @program: FSNH_Manager
 * @description:
 * @author: yaomaoyang
 * @create: 2019-06-25 10:08
 **/
@Data
public class UserInfo {

    private Integer id;

    private String userName;

    private String password;

    private List<Role> roles;

    private List<String> permissions;

}
