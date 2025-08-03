package com.george.mapper;


import com.george.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user_info")
    List<User> selectAllUsers();

    @Select("select * from user_info where id = #{id}")
    User selectById(@Param("id") int id);

    @Select("select count(*) from user_info where username = #{username}")
    int selectByName(@Param("username") String username);

    @Insert("insert into user_info (username, gender, email) values (#{username}, #{gender}, #{email})")
    void addUser(User user);

    @Update("update user_info " +
            "set username = #{username}, " +
                "gender = #{gender}, " +
                "email = #{email}" +
            "where " +
                "id = #{id}")
    int update(User user);

    @Delete("delete from user_info where id = #{id}")
    void delete(int id);
}
