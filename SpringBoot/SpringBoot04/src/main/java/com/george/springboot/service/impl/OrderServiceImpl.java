package com.george.springboot.service.impl;


import com.george.springboot.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void generate() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
    }

    @Override
    public void detail() {
        try {
            Thread.sleep(2541);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("    " + "订单信息如下：******");
        if(1 == 1){
            throw new RuntimeException("测试异常通知！异常通知发生时：后置通知 和 后环绕 不会被执行！");
        }
    }

    @Override
    public void modify() {
        try {
            Thread.sleep(1010);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
    }
}
