package com.george.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 第一种方式使用原生的Servlet API
     *
     * @param request 请求
     * @return "ok"
     */
    @RequestMapping("/reg01")
    public String register(HttpServletRequest request){
        //使用 Servlet 原生 API
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("sex"));
        System.out.println(request.getParameter("interest"));
        System.out.println(request.getParameter("info"));

        return "ok";
    }

    /**
     * 第二种方式：使用SpringMVC框架提供的一个注解: @RequestParam（请求参数）
     *
     * @param username 用户名
     * @param password 密码
     * @param sex 性别
     * @param interest 兴趣
     * @param info 简介
     * @return "ok"
     */
    @PostMapping("/reg02")  // @RequestParam 会自动进行 类型转换
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("sex") Integer sex,
            @RequestParam("interest") String[] interest,
            @RequestParam("info") String info
    ){
        System.out.println(username);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(interest));
        System.out.println(info);

        return "ok";
    }
}
