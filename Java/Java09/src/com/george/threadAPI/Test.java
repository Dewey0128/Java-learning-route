package com.george.threadAPI;

public class Test {
    public static void main(String[] args) {
        Thread thread1 = new MyThread("1号线程");
        //设置线程名setName()
        thread1.setName("1号线程");
        thread1.start();
        //获取线程名getName()
        System.out.println(thread1.getName());

        Thread thread2 = new MyThread("2号线程");
        thread2.setName("2号线程");
        thread2.start();
        System.out.println(thread2.getName());

        //主线程名获取
        Thread m = Thread.currentThread();
        m.setName("主线程");
        System.out.println(m.getName());
        for (int i = 0; i < 5; i++) {
            System.out.println("Main线程：" + i);
        }
    }
}
