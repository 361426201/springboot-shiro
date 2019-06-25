package com.ymy.shiro.mapper;

import com.ymy.shiro.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {


    @Select("select permission from permission where role_id = #{id}")
    List<String> getListByRoleId(Integer id);
}
