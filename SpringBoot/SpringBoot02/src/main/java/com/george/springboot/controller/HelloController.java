package com.george.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloSpringInitializr(){
        return "Hello Spring Initializr!!!";
    }
}
