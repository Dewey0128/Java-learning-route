package com.george.threadpoolexecutors;

import com.george.threadpool.threadpoolcallable.MyCallable;

import java.util.concurrent.*;

@SuppressWarnings("all")
public class ThreadPoolTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.通过ThreadPoolExecutor创建了一个线程池对象
        /*ExecutorService pool = new ThreadPoolExecutor(
                3,
                5,
                8,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );*/

        //2. 通过Executor场景一个线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(3);

        //3. 如何配置核心线程数
        //      计算密集型的任务 ： 核心线程数量 = CPU的核数 + 1;
        //      IO密集型的任务 ： 核心线程数量 = CPU核数 * 2;



        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
    }
}
