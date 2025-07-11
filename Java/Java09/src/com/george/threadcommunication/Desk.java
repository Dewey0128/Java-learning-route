package com.george.threadcommunication;

import java.util.ArrayList;
import java.util.List;

public class Desk {
    private List<String> list = new ArrayList<>();

    //厨师线程
    public synchronized void put(){
        try {
            //获取线程相关信息
            Thread t = Thread.currentThread();
            //判断桌子食物数量
            if(list.size() == 0){
                list.add(t.getName() + "食物");
                System.out.println((t.getName() + "生成了一个食物,当前桌上有" + list.size() + "个食物"));
                Thread.sleep(2000);

                //唤醒别人，等待自己
            }else{
                System.out.println(t.getName() + "想要生成食物,但桌子满了");
                //唤醒别人，等待自己
            }
            this.notifyAll();
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //顾客线程
    public synchronized void get(){
        try {
            Thread t = Thread.currentThread();
            if( list.size() > 0){
                list.remove(0);
                System.out.println(t.getName() + "消费了一个食物,当前桌上还有" + list.size() + "个食物");
                Thread.sleep(2000);

                //唤醒别人，等待自己
                this.notifyAll();
                this.wait();
            }else{
                System.out.println(t.getName() + "想要生成食物,但桌子空了");
                //唤醒别人，等待自己
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
