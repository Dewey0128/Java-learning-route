package com.george.springboot.valueconfig;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueConfig {
    @Value("${myValue.username}")
    private String username;

    @Value("${myValue.password}")
    private String password;

    @Value("${myValue.age}")
    private Integer age;

    public String toString() {
        return "ValueConfig{username = " + username + ", password = " + password + ", age = " + age + "}";
    }
}
