package com.george.springboot;


import com.george.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// springboot项目中使用单元测试junit，那么单元测试类必须使用这个注解进行标注。
@SpringBootTest
class SpringBoot02ApplicationTests {

    @Autowired
    private UserService userService;

    // 单元测试方法，单元测试方法使用 @Test 注解标注。
    @Test
    void getUser() {
        System.out.println(userService.getUser());
    }

}
