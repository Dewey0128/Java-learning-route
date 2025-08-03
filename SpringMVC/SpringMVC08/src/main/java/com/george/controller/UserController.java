package com.george.controller;

import com.george.pojo.User;
import com.george.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ModelAndView selectAllUsers(){
        List<User> users = userService.selectAllUsers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("user_list");

        return modelAndView;
    }

    @GetMapping("/user_add")
    public ModelAndView toAddHtml(){
        return new ModelAndView("user_add");
    }

    @PostMapping("/user")
    public ModelAndView addUser(User user){
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView("user_list");

        if(userService.selectByName(user.getUsername()) == 0){
            userService.addUser(user);
            modelAndView.addObject("msg","新增成功！");
        }else{
            modelAndView.addObject("msg","新增失败！");
        }

        return modelAndView;
    }

    @GetMapping("/user/edit/{id}")
    public ModelAndView editAndDel(@PathVariable("id") int id){
        User user = userService.selectById(id);
        ModelAndView modelAndView = new ModelAndView("user_edit");

        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @RequestMapping("/user/update")
    public ModelAndView update(User user){
        ModelAndView modelAndView = new ModelAndView("redirect:/user");

        System.out.println("************************");
        System.out.println(user);

        userService.update(user);

        return modelAndView;
    }

    @RequestMapping("/user/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/user");


        System.out.println("************************");
        userService.delete(id);

        return modelAndView;
    }
}
