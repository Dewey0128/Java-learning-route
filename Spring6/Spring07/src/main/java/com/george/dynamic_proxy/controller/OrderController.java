package com.george.dynamic_proxy.controller;

import com.george.dynamic_proxy.service.Impl.OrderServiceDynamicImpl;
import com.george.dynamic_proxy.service.MyInvocationHandler.TimerInvocationHandler;
import com.george.dynamic_proxy.service.OrderService;
import jakarta.annotation.Resource;
import java.lang.reflect.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Proxy;

@Controller
public class OrderController {

    @Resource
    private OrderServiceDynamicImpl dynamicProxy;

    public void generate() {
        dynamicProxy.getOrderServiceProxy().generate();
    }


    public void detail() {
        dynamicProxy.getOrderServiceProxy().detail();
    }

    public void modify() {
        dynamicProxy.getOrderServiceProxy().modify();
    }
}

