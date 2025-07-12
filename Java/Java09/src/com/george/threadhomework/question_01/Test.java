package com.george.threadhomework.question_01;


import java.util.concurrent.*;

/**
 * 第一题：分析以下需求，并用代码实现<br>
 * 训练目标：<br>
 * &emsp;&emsp;掌握java中多线程基本使用<br>
 * 需求描述：<br>
 * &emsp;&emsp;有100份礼品，小红，小明两人同时发送，当剩下的礼品小于10份的时候则不再送出，利用多线程模拟该过程并将线程的名称打印出来。并最后在控制台分别打印小红，小明各自送出多少分礼物。
 * */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.通过ThreadPoolExecutor创建了一个线程池对象
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                2,
                8,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        MyCallable myCallable = new MyCallable(100);

        while (true) {
            Future<String> f1 = pool.submit(myCallable);
            Future<String> f2 = pool.submit(myCallable);

            System.out.println(f1.get());
            System.out.println(f2.get());

            if(myCallable.getCount() < 10){
                break;
            }
        }

        pool.shutdown();
        System.out.println("小红送出：" + myCallable.getReckoning().getCount_1());
        System.out.println("小明送出：" + myCallable.getReckoning().getCount_2());
    }
}
