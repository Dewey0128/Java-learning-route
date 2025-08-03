package com.george.service;

import com.george.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<User> selectAllUsers();


    User selectById(int id);

    int selectByName(String username);

    void addUser(User user);

    int update(User user);

    void delete(int id);
}
