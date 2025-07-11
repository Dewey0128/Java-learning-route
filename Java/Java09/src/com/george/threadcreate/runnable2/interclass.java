package com.george.threadcreate.runnable2;

/**
 * 目标掌握：Runnable的匿名内部类写法
 * */
public class interclass {
    public static void main(String[] args) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("Runnable线程：" + i);
                }
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main线程：" + i);
        }
    }
}
