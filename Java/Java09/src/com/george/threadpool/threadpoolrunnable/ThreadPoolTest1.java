package com.george.threadpool.threadpoolrunnable;

import java.util.concurrent.*;
/**
 * 参数一：corePoolSize 指定线程池的核心线程的数量。 ——> 正式工：3
 * 参数二：maximumPoo1Size:指定线程池的最大线程数量。 ——> 最大员工数：5
 * 参数三：keepAliveTime：指定临时线程的存活时间。  ——> 临时工空闲多久被开除  临时工：2
 * 参数四：unit:指定临时线程存活的时间单位（秒、分、时、天）
 * 参数五：workQueue:指定线程池的任务队列。 ——> 客人排队的地方
 * 参数六：threadFactory:指定线程池的线程工厂。 ——> 负责招聘员工的（hr）
 * 参数七：handler:指定线程池的任务拒绝策略（线程都在忙，任务队列也满了的时候，新任务来了该怎么处理） ——> 忙不过来咋办？
 * */
public class ThreadPoolTest1 {
    public static void main(String[] args) {
        //1.通过ThreadPoolExecutor创建了一个线程池对象
        ExecutorService pool = new ThreadPoolExecutor(
                3,
                5,
                8,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Runnable target = new MyRunnable();
        // 3 个核心线程
        pool.execute(target);//线程池会自动创建一个新线程，自动处理这个任务，自动执行的！
        pool.execute(target);//线程池会自动创建一个新线程，自动处理这个任务，自动执行的！
        pool.execute(target);//线程池会自动创建一个新线程，自动处理这个任务，自动执行的！
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        // 到了临时线程的创建时机
        pool.execute(target);
        pool.execute(target);
        //到了拒绝任务时机
        try {
            pool.execute(target);
            pool.execute(target);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("核心线程和临时线程都在忙，任务队列也满了,新的任务过来的时候开始拒绝任务。");
        }


        //等着线程池的任务全部执行完毕后，再关闭线程池
        /*pool.shutdown();*/

        //立即关闭线程池！不管任务是否执行完毕！
        /*pool.shutdownNow();*/
    }
}
