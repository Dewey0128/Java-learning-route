package com.george.autowired.controller;

import com.george.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//1. 注入bean
@Controller
public class UserController {
    //注入Service
    // 第一种方式 属性注入
    @Autowired  // 根据类型找到对应对象， 完成注入
    private UserService userService;

    public void userControllerAdd(){
        System.out.println("UserController add ...");
        userService.userServiceAdd();
    }
}
