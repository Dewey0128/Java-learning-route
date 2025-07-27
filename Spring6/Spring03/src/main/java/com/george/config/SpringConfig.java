package com.george.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"com.george.resource.controller", "com.george.resource.service","com.george.resource.dao"})
@ComponentScan("com.george.resource")
public class SpringConfig {

}
