package com.george.springboot.valueconfig;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValueConfigTest {

    @Autowired
    private ValueConfig valueConfig;

    @Test
    public void testValueBind(){
        System.out.println(valueConfig);
    }




}
