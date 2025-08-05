package com.george.springboot.mergeconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MergeConfigTest {

    @Autowired
    private MergeConfig mergeConfig;

    @Test
    public void testMergeConfig(){
        System.out.println(mergeConfig);
    }

}
