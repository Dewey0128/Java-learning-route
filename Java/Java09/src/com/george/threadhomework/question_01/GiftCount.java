package com.george.threadhomework.question_01;

public class GiftCount {
    private int count_1;
    private int count_2;

    public GiftCount() {
    }

    public GiftCount(int count_1, int count_2) {
        this.count_1 = count_1;
        this.count_2 = count_2;
    }

    public void inc_count_1(){
        count_1 ++;
    }

    public void inc_count_2(){
        count_2 ++;
    }


    /**
     * 获取
     * @return count_1
     */
    public int getCount_1() {
        return count_1;
    }

    /**
     * 设置
     * @param count_1
     */
    public void setCount_1(int count_1) {
        this.count_1 = count_1;
    }

    /**
     * 获取
     * @return count_2
     */
    public int getCount_2() {
        return count_2;
    }

    /**
     * 设置
     * @param count_2
     */
    public void setCount_2(int count_2) {
        this.count_2 = count_2;
    }

    public String toString() {
        return "GiftCount{count_1 = " + count_1 + ", count_2 = " + count_2 + "}";
    }
}
