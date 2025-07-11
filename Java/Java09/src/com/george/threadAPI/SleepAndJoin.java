package com.george.threadAPI;

public class SleepAndJoin {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if( i == 3){
                //会让当前线程休眠
                Thread.sleep(4000);
            }
        }

        //Join方法作用：让当前调用这个方法的线程先执行完
        Thread thread1 = new MyThread("1号线程");
        thread1.start();
        thread1.join();


        Thread thread2 = new MyThread("2号线程");
        thread2.start();
        //thread2.join();

        Thread thread3 = new MyThread("3号线程");
        thread3.start();
        thread3.join();

    }
}
