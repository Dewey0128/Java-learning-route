package com.george.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringBoot03Application {

    @Bean
    public Date getDate(){
        return new Date();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot03Application.class, args);
    }

}
