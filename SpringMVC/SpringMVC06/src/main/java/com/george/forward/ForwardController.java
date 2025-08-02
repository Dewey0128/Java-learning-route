package com.george.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forward")
public class ForwardController {
    @RequestMapping("/a")
    public String toA(){
        return "forward:/forward/b";
    }

    @RequestMapping("/b")
    public String toB(){
        return "b";
    }
}
