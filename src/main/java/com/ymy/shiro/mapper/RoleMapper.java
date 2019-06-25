package com.ymy.shiro.mapper;

import com.ymy.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from role where user_id = #{id}")
    List<Role> getRoleByUserId(Integer id);
}
