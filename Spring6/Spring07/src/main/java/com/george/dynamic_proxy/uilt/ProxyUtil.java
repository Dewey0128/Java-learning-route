package com.george.dynamic_proxy.uilt;

import com.george.dynamic_proxy.service.MyInvocationHandler.TimerInvocationHandler;
import com.george.dynamic_proxy.service.OrderService;

import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Object newProxyInstance(Object target){
        /*
         * 1.newProxyInstance ：新建代理对象
         *   本质上，这个Proxy.newProxyInstance()方法的执行，做了俩件事：
         *       第一件事：在内存中动态生成了一个代理类的字节码class
         *       第二件事：new对象。通过内存中生成的代理类这个代码，实例化了代理对象
         * 2.关于newProxyInstance()方法的三个重要参数：
         *       第一个参数：ClassLoader loader
         *           类加载器：在内存中生成了字节码，要想执行这个字节码，也是需要先把这个字节码加载到内存当中的。
         *                       所以要指定使用哪个类加载器加载。
         *                   JDK要求，目标类的类加载器必须和代理类的类加载器使用一个
         *       第二个参数：Class<?>[] interfaces
         *           代理类和目标类要实现同一个接口或同一些接口
         *           在内存中生成代理类的时候，这个代理类是需要你告诉它实现哪些接口的。
         *       第三个参数：InvocationHandler n
         *           InvocationHandler : 调用处理器。是一个接口
         *               在调用处理器接口中编写的就是：增强代码
         *               既然是接口，就要写接口的实现类
         * */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
    }
}
