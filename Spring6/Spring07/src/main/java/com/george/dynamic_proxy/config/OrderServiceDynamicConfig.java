package com.george.dynamic_proxy.config;

import com.george.dynamic_proxy.service.OrderService;
import com.george.dynamic_proxy.proxy.util.ProxyUtil;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceDynamicConfig {
    @Resource
    private OrderService target;

    @Bean
    public OrderService orderServiceProxy() {
        return (OrderService) ProxyUtil.newProxyInstance(target);
    }
}