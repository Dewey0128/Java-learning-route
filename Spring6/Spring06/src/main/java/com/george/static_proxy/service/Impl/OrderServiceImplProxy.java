package com.george.static_proxy.service.Impl;

import com.george.static_proxy.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/*
* 以上就是代理模式中的静态代理，
*   其中OrderService接口是代理类和目标类的共同接口。
*       OrderServiceImpl是目标类。OrderServiceProxy是代理类。
* 大家思考一下：
*   如果系统中业务接口很多，一个接口对应一个代理类，显然也是不合理的，会导致类爆炸。
*   怎么解决这个问题？
*       动态代理可以解决。
*       因为在动态代理中可以在内存中动态的为我们生成代理类的字节码。
*       代理类不需要我们写了。
*       类爆炸解决了，而且代码只需要写一次，代码也会得到复用
* */

// 代理对象
@Service("proxy")
public class OrderServiceImplProxy implements OrderService {

    // 目标对象
    @Resource
    private OrderService target;

    // 通过构造方法将目标对象传递给代理对象
    public OrderServiceImplProxy(OrderService target) {
        this.target = target;
    }


    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        // 执行目标对象的目标方法
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin)+"毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        // 执行目标对象的目标方法
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin)+"毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        // 执行目标对象的目标方法
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin)+"毫秒");
    }

}
