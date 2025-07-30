package com.george.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstController {
    @RequestMapping(value="/myspringmvc")
    public String mySpringMVC(){
        System.out.println("zkkkkkkkkkkk");
        System.out.println("正在处理请求....");
        // 返回逻辑视图名称（决定跳转到哪个页面）
        return "MySpringMVC";
    }

    @RequestMapping("aSpringMVC")
    public String aSpringMVC(){
        return "aSpringMVC";
    }
}
