package com.george.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/method")
public class MethodController {

    @RequestMapping(value="/login01", method = RequestMethod.POST)
    public String userLogin01(){
        return "ok";
    }

    //衍生Mapping
    //    @PostMapping 注解代替的是：@RequestMapping(value="", method=RequestMethod.POST)
    //    @GetMapping 注解代替的是：@RequestMapping(value="", method=RequestMethod.GET)
    //    ....
    //    @PutMapping
    //    @DeleteMapping
    //    @PatchMapping
    @PostMapping("/login02")
    public String userLogin02(){
        return "ok";
    }
}
