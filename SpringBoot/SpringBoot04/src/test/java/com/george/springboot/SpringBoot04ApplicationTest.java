package com.george.springboot;

import com.george.springboot.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBoot04ApplicationTest {


    private final OrderService orderService;

    @Autowired
    public SpringBoot04ApplicationTest(OrderService orderService) {
        this.orderService = orderService;
    }

    @Test
    public void testAOP(){
        orderService.generate();
        orderService.detail();
        orderService.modify();
    }

}
