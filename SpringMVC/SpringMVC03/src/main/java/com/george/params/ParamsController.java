package com.george.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @RequestMapping(value = "/testParams01", params = {"username", "password"})
    public String testParams01(){
        return "ok";
    }

    @RequestMapping(path = "/testParams02", params = {"！username", "password"})
    public String testParams02(){
        return "ok";
    }
}
