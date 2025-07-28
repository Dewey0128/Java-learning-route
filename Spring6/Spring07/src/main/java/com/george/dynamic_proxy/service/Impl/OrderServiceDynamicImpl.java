package com.george.dynamic_proxy.service.Impl;

import com.george.dynamic_proxy.service.MyInvocationHandler.TimerInvocationHandler;
import com.george.dynamic_proxy.service.OrderService;
import com.george.dynamic_proxy.uilt.ProxyUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;

@Service("dynamicProxy")
public class OrderServiceDynamicImpl {
    // 第一步：创建目标对象
    @Resource
    private OrderService target;

    // 第二步：创建代理对象
    private OrderService orderServiceProxy;

    @PostConstruct
    public void init() {
        this.orderServiceProxy = (OrderService) ProxyUtil.newProxyInstance(this.target);
    }

    public OrderService getOrderServiceProxy() {
        return orderServiceProxy;
    }
}