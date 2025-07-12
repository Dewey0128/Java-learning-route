package com.george.OptimisticPessimisticLock;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable1 implements Runnable{
    private int count;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //悲观锁
            synchronized (MyRunnable1.class) {
                System.out.println(Thread.currentThread().getName() + ": 执行了count++值为：" + ++count);
            }
        }
    }
}
