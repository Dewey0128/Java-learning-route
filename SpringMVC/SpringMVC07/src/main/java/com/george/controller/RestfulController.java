package com.george.controller;

import com.george.pojo.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestfulController {
    /**
     * 查询 用户 信息
     *      发起GET请求
     *
     * @return modelAndView
     */
    @GetMapping("/user")
    public ModelAndView testGet01(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlType","http://localhost:8080/springmvc/user");
        modelAndView.addObject("testType","测试 REATFul 的 GET 请求");
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    /**
     * 查询 用户 信息
     *      发起GET请求
     *
     * @return modelAndView
     */
    @GetMapping("/user/{id}")
    public ModelAndView testGet02(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlType","http://localhost:8080/springmvc/user/120");
        modelAndView.addObject("testType","测试 REATFul 的 GET 请求");
        modelAndView.setViewName("ok");

        System.out.println(id);
        return modelAndView;
    }

    /**
     * 提交 用户 信息
     *      发起Post请求
     *
     * @return modelAndView
     */
    @PostMapping("/user")
    public ModelAndView testPost(@RequestBody String requestBodyStr){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlType","http://localhost:8080/springmvc/user");
        modelAndView.addObject("testType","测试 REATFul 的 Post 请求");
        modelAndView.setViewName("ok");

        System.out.println(requestBodyStr);

        return modelAndView;
    }


    /**
     * 修改 用户 信息
     *      发起PUT请求
     *
     * @return modelAndView
     */
    @PutMapping("/user")
    public ModelAndView testPut(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlType","http://localhost:8080/springmvc/user");
        modelAndView.addObject("testType","测试 REATFul 的 Put 请求");
        modelAndView.setViewName("ok");

        System.out.println(user);
        return modelAndView;
    }

    /**
     * 删除 用户 信息
     *      发起DELETE请求
     *
     * @return modelAndView
     */
    @DeleteMapping("/user/{id}")
    public ModelAndView testDelete(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlType","http://localhost:8080/springmvc/user/123");
        modelAndView.addObject("testType","测试 REATFul 的 Delete 请求");
        modelAndView.setViewName("ok");

        System.out.println(id);

        return modelAndView;
    }
}
