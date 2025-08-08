package com.george.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 使用该注解标注，表示该类为配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 只要访问 localhost:8080/static/** 就访问 根路径下的 myStatic 路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/myStatic");
    }
}
