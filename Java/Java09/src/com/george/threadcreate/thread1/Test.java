package com.george.threadcreate.thread1;

/*
    目标：掌握线程的创建方式 一 ： 继承Thread类
* */
public class Test {
    //Main方法是由一条默认的主线程负责执行
    public static void main(String[] args) {
        //3.创建Mythread线程类的对象代表一个线程
        Thread t = new MyThread();
        //4.启动线程（自动执行run方法）
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main线程：" + i);
        }
    }
}
