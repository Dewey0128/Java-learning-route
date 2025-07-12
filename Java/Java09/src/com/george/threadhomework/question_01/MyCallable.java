package com.george.threadhomework.question_01;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int count;
    private GiftCount reckoning = new GiftCount();

    public MyCallable(int count){
        this.count = count;
    }

    public MyCallable() {
    }

    public MyCallable(int count, GiftCount reckoning) {
        this.count = count;
        this.reckoning = reckoning;
    }

    @Override
    public String call() throws Exception {
        synchronized (this) {
            if(count >= 10){
                if(Thread.currentThread().getName().equals("pool-1-thread-1")){
                    -- count;
                    reckoning.inc_count_1();
                    Thread.sleep(300);
                    return "小红送出一份礼物,还剩余：" + count + "份";
                }else{
                    -- count;
                    reckoning.inc_count_2();
                    Thread.sleep(300);
                    return "小明送出一份礼物,还剩余：" + count + "份";
                }

            }else{
                Thread.sleep(300);
                return Thread.currentThread().getName() + "想要送出礼物,但礼物剩余：" + count + "份不够送出";
            }
        }


    }

    @SuppressWarnings("all")
    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 获取
     * @return reckoning
     */
    public GiftCount getReckoning() {
        return reckoning;
    }

    /**
     * 设置
     * @param reckoning
     */
    public void setReckoning(GiftCount reckoning) {
        this.reckoning = reckoning;
    }

    public String toString() {
        return "MyCallable{count = " + count + ", reckoning = " + reckoning + "}";
    }
}
