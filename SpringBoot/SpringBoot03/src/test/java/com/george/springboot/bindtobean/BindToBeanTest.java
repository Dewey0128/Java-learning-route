package com.george.springboot.bindtobean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BindToBeanTest {

    @Autowired
    private BindToBeanConfig bindToBeanConfig;

    @Test
    public void testBindToBean(){
        System.out.println(bindToBeanConfig);
    }

}
