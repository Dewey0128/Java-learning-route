package com.george.value;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. @RequestMapping注解可以出现在类上，也可以出现在方法上
@Controller
@RequestMapping("/value")
public class ValueController {

    @RequestMapping("/first")
    public String first(){
        return "value_first";
    }

    // 2. @RequestMapping value属性本身是一个 String[] 字符串数组，说明多个请求路径可以映射同一个处理器方法。
    @RequestMapping(value = {"/2nd", "/second"})
    public String Second(){
        return "value_second";
    }

    // 3. @RequestMapping的value属性支持Ant风格的，支持模糊匹配的路径
    //      ?   表示任意一个字符。（除 / ? 之外的其它字符），注意：一定是一个字符哦。不能空着。
    //      *   表示0到N个任意字符。（除 / ? 之外的其它字符）。
    //      **  表示0到N个任意字符。并且路径中可以出现 /
    @RequestMapping(value = {"/?", "*"})   // http://localhost:8080/springmvc/value/a
    public String ant(){
        return "index";
    }

    // 4. @RequestMapping注解的value属性上的占位符（重点）
    //    现在的开发比较流行使用RESTFul风格的URL：
    //        /springmvc/login/admin/123
    @RequestMapping("/login/{username}/{password}")
    public String restful(
            @PathVariable("username") String username,
            @PathVariable("password") String password
    ){
        System.out.println("用户名：" + username + "，密码：" + password);
        return "index";
    }
}
