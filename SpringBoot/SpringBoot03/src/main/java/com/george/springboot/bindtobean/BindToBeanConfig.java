package com.george.springboot.bindtobean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bind.bean")
//使用这种方式：一定要有 setter 方法
public class BindToBeanConfig {

    private String username;
    private String password;
    private Integer age;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "ValueConfig{username = " + username + ", password = " + password + ", age = " + age + "}";
    }
}
