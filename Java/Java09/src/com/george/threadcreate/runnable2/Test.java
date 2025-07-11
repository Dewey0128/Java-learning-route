package com.george.threadcreate.runnable2;

public class Test {
    public static void main(String[] args) {
        //3.创建任务对象
        Runnable r = new MyRunnable();
        //4.把任务对象交给Tread对象处理
        new Thread(r).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main线程：" + i);
        }
    }
}
