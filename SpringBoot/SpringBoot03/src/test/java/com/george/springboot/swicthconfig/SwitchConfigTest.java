package com.george.springboot.swicthconfig;

import com.george.springboot.switchconfig.SwitchConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SwitchConfigTest {

    @Autowired
    private SwitchConfig switchConfig;

    @Test
    public void testMerge(){
        System.out.println(switchConfig);
    }

}
