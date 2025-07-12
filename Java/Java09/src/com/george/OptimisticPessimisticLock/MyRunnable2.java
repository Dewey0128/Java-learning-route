package com.george.OptimisticPessimisticLock;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable2 implements Runnable{
    //private int count;
    //整数修改的乐观锁 ；原子类实现的。
    private final AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //乐观锁
            /**
             *      public final int incrementAndGet () {
             *          //this -> AtomicInteger地址
             *          //valueOffset -> value值的地址
             *          //    static {
             *                      try {
             *                          valueOffset = unsafe.objectFieldOffset
             *                          (AtomicInteger.class.getDeclaredField("value"));
             *                      } catch (Exception ex) { throw new Error(ex); }
             *                  }
             *              public final int getAndAddInt(Object var1, long var2, int var4) {
             *                  int var5;
             *                  do {
             *                      var5 = this.getIntVolatile(var1, var2);
             *                  } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
             *
             *                  return var5;
             *              }
             */
            System.out.println(Thread.currentThread().getName() + ": 执行了count++值为：" + count.incrementAndGet());
        }
    }
}

