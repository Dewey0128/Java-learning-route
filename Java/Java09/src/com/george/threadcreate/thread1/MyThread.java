package com.george.threadcreate.thread1;

/**
 *1.让子类继承Thread线程类
 */
public class MyThread extends Thread{
    /**
     * 2.必须重写Thread的ren方法
     * */
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("Thread线程：" + i);
        }
    }
}
