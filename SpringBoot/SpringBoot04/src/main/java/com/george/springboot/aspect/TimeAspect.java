package com.george.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@Order(1) // 数字越小，级别越高
public class TimeAspect {   //切面

    //切面 = 通知 + 切点
    //通知就是增强代码
    //这里的Advice以方法的形式出现（因为方法中可以写代码）

    /*切点表达式：()

    *   execution([访问控制权限修饰符] 返回值类型 [全限定类名]方法名(形式参数列表) [异常])

        * [访问控制权限修饰符]：
            - 可选项。
            - 没写，就是4个权限都包括。
            - 写public就表示只包括公开的方法。
        * 返回值类型：
            - 必填项。
            - * 表示返回值类型任意。
        * [全限定类名]：
            - 可选项。
            - 两个点“..”代表当前包以及子包下的所有类。
            - 省略时表示所有的类。
        * 方法名：
            - 必填项。
            - *表示所有方法。
            - set*表示所有的set方法。
        * 形式参数列表：
            - 必填项
            - () 表示没有参数的方法
            - (..) 参数类型和个数随意的方法
            - (*) 只有一个参数的方法
            - (*, String) 第一个参数类型随意，第二个参数是String的。
        * [异常]：
            - 可选项。
            - 省略时表示任意异常类型。
    * */

    // 切点1：只要detail方法
    @Pointcut("execution(* com.george..*(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.generate(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.modify(..))")
    public void detailAdvice() {}

    // 切点2：只要modify方法
    @Pointcut("execution(* com.george..*(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.generate(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.detail(..))")
    public void modifyAdvice() {}

    // 切点2：只要generate方法
    @Pointcut("execution(* com.george..*(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.detail(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.modify(..))")
    public void generateAdvice() {}



    //@Before 注解标注的方法就是一个前置通知
    @Before("detailAdvice()")
    public void beforeAdvice(){
        System.out.println("前置通知：" + LocalDateTime.now());
    }

    @AfterReturning("execution(* com.george..*(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.generate(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.modify(..))")
    public void afterReturningAdvice(){
        System.out.println("后置通知：" + LocalDateTime.now());
    }

    @Around("execution(* com.george..*(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.generate(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.modify(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前环绕：" + LocalDateTime.now());

        joinPoint.proceed();

        System.out.println("后环绕：" + LocalDateTime.now());
    }

    @AfterThrowing("execution(* com.george..*(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.generate(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.modify(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知：" + LocalDateTime.now());
    }

    @After("execution(* com.george..*(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.generate(..)) " +
            "&& !execution(* com.george.springboot.service.impl.OrderServiceImpl.modify(..))")
    public void afterAdvice(){
        System.out.println("最终通知：" + LocalDateTime.now());
    }

}
