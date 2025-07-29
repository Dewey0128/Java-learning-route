package com.george.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration  // 代替bean.xml文件
@ComponentScan({"com.george"})
@EnableAspectJAutoProxy
public class Spring6Config {
}
