package com.george;


import com.george.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBoot05ApplicationTest {
    @Autowired
    private UserController userController;

    @Test
    public void testFindAll(){
        userController.findAll().forEach(System.out::println);
    }
}
