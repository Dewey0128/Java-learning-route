package com.george.static_proxy.controller;

import com.george.static_proxy.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    @Resource
    private OrderService proxy;

    public void generate() {
        proxy.generate();
    }


    public void detail() {
        proxy.detail();
    }

    public void modify() {
        proxy.modify();
    }
}
