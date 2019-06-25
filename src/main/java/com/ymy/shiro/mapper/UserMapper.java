package com.ymy.shiro.mapper;

import com.ymy.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where user_name = #{name} and password = #{pwd}")
    User getUserByName(@Param("name") String name, @Param("pwd")String pwd);
}
