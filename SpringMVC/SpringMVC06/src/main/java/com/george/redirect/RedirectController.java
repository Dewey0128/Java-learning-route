package com.george.redirect;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @RequestMapping("/a")
    public String toA(){
        return "redirect:/redirect/b";
    }

    @RequestMapping("/b")
    public String toB(){
        // 不仅可以内部资源访问，还可以跨域 访问
        return "redirect:https://www.bing.com/";
    }
}
