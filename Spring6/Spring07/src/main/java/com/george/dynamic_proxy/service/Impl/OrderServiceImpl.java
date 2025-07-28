package com.george.dynamic_proxy.service.Impl;

import com.george.dynamic_proxy.service.OrderService;
import org.springframework.stereotype.Service;

/*
* 项目已上线，并且运行正常，只是客户反馈系统有一些地方运行较慢，要求项目组对系统进行优化。
* 于是项目负责人就下达了这个需求。
*       首先需要搞清楚是哪些业务方法耗时较长，于是让我们统计每个业务方法所耗费的时长。
* 如果是你，你该怎么做呢？
* */

/// 目标对象
@Service("target")
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单信息如下：******");
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
