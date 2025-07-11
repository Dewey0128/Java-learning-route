package com.george.threadcreate.callable3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 目标：掌握线程的创建方式三 ：实现Callable接口
 * */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3.创建一个Callable的对象
        Callable<String> c = new MyCallable(100);
        //4.把Callable的1对象封装成一个FutureTask对象（任务对象）
        /**
         * 未来任务对象的作用：
         *      1.是一个任务对象，实现了Runable对象
         *      2.可以在线程执行完毕后，用未来对象调用get方法获取线程执行完毕后的返回值
         * */
        FutureTask<String> f = new FutureTask<>(c);
        //5.把任务对象交给一个Thread对象
        new Thread(f).start();

        //6.获取线程执行完毕后的返回结果
        //这里代码会暂停，等待上面线程执行完毕后才会会获取结果
        System.out.println(f.get());
    }
}
