package com.george.dynamic_proxy.controller;

import com.george.dynamic_proxy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderServiceProxy;

    public void generate() {
        orderServiceProxy.generate();
    }

    public void detail() {
        orderServiceProxy.detail();
    }

    public void modify() {
        orderServiceProxy.modify();
    }
}