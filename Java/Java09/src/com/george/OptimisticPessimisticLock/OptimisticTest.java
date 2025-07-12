package com.george.OptimisticPessimisticLock;

public class OptimisticTest {
    public static void main(String[] args) {
        // 目标：扩展悲观锁， 乐观锁原理
        //乐观锁 ： 一开始不上锁，认为是没有问题的，CAS算法
        Runnable target = new MyRunnable2();

        for (int i = 0; i < 100; i++) {
            new Thread(target).start();
        }
    }
}
