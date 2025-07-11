package com.george.threadAPI;

public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        //哪个线程执行run,它就会得到哪个线程对象
        Thread T = Thread.currentThread();
        for (int i = 0; i < 20; i++) {
            System.out.println(T.getName() + "输出： "+ i );
        }
    }
}
