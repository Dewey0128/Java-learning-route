package com.george.threadcreate.runnable2;

/**
 * 1.定义一个任务类，实现Runnable接口
 * */
public class MyRunnable implements Runnable {
    /**
     * 2.重写Runnable的run方法
     * */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Runnable线程：" + i);
        }
    }
}
