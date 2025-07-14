package com.george.threadhomework.question_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryBox implements PrintInfo{
    //创建数组存放{10,5,20,50,100,200,500,800,2,80,300,700};
    private final int[] prizes = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700};
    //创建List存放抽奖结果
    private final List<Integer> results1 = new ArrayList<>();
    private final List<Integer> results2 = new ArrayList<>();
    //记录最高奖项
    private int[] maxPrize = {-1, -1};

    public LotteryBox() {
    }

    public boolean draw(){
        Random random = new Random();
        int index = random.nextInt(prizes.length);
        int price = prizes[index];
        prizes[index] = -1;
        if(price != -1){
            if(Thread.currentThread().getName().equals("抽奖箱 1") && maxPrize[0] < price){
                maxPrize[0] = price;
            }else if (Thread.currentThread().getName().equals("抽奖箱 2") && maxPrize[1] <= price){
                maxPrize[1] = price;
            }
            if(Thread.currentThread().getName().equals("抽奖箱 1")){
                results1.add(price);
            }else if (Thread.currentThread().getName().equals("抽奖箱 2")){
                results2.add(price);
            }
            System.out.println(Thread.currentThread().getName() + "又产生了一个 " + price + " 元大奖");
            return true;
        }else {
            return false;
        }
    }

    public int[] getMaxPrize() {
        return maxPrize;
    }

    public List<Integer> getResults1(){
        return results1;
    }

    public List<Integer> getResults2(){
        return results2;
    }

    public void printInfo(){
        System.out.println("在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：" + results1 + "最高奖项为" + maxPrize[0] + ",总奖金为：" + sum_res(results1));
        System.out.println("在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：" + results2 + "最高奖项为" + maxPrize[1] + ",总奖金为：" + sum_res(results2));
    }

    public int sum_res(List<Integer> results){
        int count = 0;
        for (Integer result : results) {
            count += result;
        }
        return count;
    }
}
