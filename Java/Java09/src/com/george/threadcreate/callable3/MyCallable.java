package com.george.threadcreate.callable3;

import java.util.concurrent.Callable;

/**
 * 1.让这个类实现Callable接口
 * */
public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    /**
    * 2.重写call方法
    * */
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "线程求出了1 - " + n + "的和是：" + sum;
    }

    /**
     * 获取
     * @return n
     */
    public int getN() {
        return n;
    }

    /**
     * 设置
     * @param n
     */
    public void setN(int n) {
        this.n = n;
    }

    public String toString() {
        return "MyCallable{n = " + n + "}";
    }
}
