package com.george.springboot.service.impl;

import com.george.springboot.pojo.User;
import com.george.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return new User(1, "周坤", "1231231");
    }
}
