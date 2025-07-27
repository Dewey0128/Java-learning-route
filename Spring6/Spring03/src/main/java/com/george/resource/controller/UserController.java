package com.george.resource.controller;

import com.george.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//1. 注入bean
@Controller
public class UserController {
    //注入Service
    @Resource(name = "myUserService")
    private UserService userService;

    public void userControllerAdd(){
        System.out.println("UserController add ...");
        userService.userServiceAdd();
    }
}
