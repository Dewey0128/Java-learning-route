package com.george.mapper;

import com.george.pojo.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {
    User search(User user);

    @Insert("insert into users (user_name, user_password) value (#{username}, #{password})")
    int insert(User user);
}
