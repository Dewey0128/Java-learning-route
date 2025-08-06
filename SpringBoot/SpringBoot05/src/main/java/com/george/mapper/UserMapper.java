package com.george.mapper;

import com.george.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
// 代替 <mapper scan = "">
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();
}
