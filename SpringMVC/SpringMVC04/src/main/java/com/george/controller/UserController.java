package com.george.controller;

import com.george.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 第三种方式：依靠控制器方法上的形参名来接收
     *         如果 请求参数名 和 控制器方法上的形参名 保持一致，那么 @RequestParam注解可以省略。
     *
     * @param username 用户名
     * @param password 密码
     * @param sex 性别
     * @param interest 兴趣
     * @param info 简介
     * @return "ok"
     */
    @PostMapping("/reg03")  // @RequestParam 会自动进行 类型转换
    public String _register(
            String username,
            String password,
            Integer sex,
            String[] interest,
            String info
    ){
        System.out.println(username);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(interest));
        System.out.println(info);

        return "ok";
    }

    /**
     * 第四种方式：使用POJO类/JavaBean接收请求参数(这是最常用的)
     *         底层实现原理：反射机制。
     *         不过，使用这种方式的前提是：POJO类的属性名必须和请求参数的参数名保持一致
     *
     * @param user pojo类
     * @return "ok"
     */
    @PostMapping("/reg04")  // @RequestParam 会自动进行 类型转换
    public String register(User user){

        System.out.println(user);

        return "ok";
    }

    /**
     * 使用 @RequestHeader 注解，它用来标注 形参。
     *      作用是：将  请求头信息  映射到   控制器方法的形参 上。
     *
     * @param user pojo
     * @param host 请求头中的 host 字段
     * @return "ok"
     */
    @PostMapping("/reg05")  // @RequestParam 会自动进行 类型转换
    public String register(User user,
                           @RequestHeader(value = "host", required = false, defaultValue = "null") String host){

        System.out.println(user);
        System.out.println(host);

        return "ok";
    }

    /**
     * 使用 @CookieValue 注解标注控制器方法上的形参。
     *     获取客户端提交的Cookie
     * @return "ok"
     */
    @RequestMapping("/reg06")
    public String register_(User user,
                           @CookieValue(value = "id", required = false, defaultValue = "")
                           String id){
        System.out.println(user);
        System.out.println("客户端提交过来的cookie，它的值是：" + id);
        return "ok";
    }
}
