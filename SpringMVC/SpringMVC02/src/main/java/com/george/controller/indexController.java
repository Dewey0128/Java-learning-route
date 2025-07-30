package com.george.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/first")
    public String first(){
        return "first";
    }
}
