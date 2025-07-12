package com.george.OptimisticPessimisticLock;


public class PessimisticTest {
    public static void main(String[] args) {
        // 目标：扩展悲观锁， 乐观锁原理
        //悲观锁 ： 直接一开始就上锁。导致性能低下
        Runnable target = new MyRunnable1();

        for (int i = 0; i < 100; i++) {
            new Thread(target).start();
        }
    }
}
