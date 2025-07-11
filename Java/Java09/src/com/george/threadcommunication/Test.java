package com.george.threadcommunication;

public class Test {
    public static void main(String[] args) {
        Desk desk = new Desk();
        //厨师 1
        new Thread(() -> {
            while(true){
                desk.put();
            }
        }, "厨师 1").start();
        //厨师 2
        new Thread(() -> {
            while(true){
                desk.put();
            }
        }, "厨师 2").start();
        //厨师 3
        new Thread(() -> {
            while(true){
                desk.put();
            }
        }, "厨师 3").start();
        //顾客 1
        new Thread(() -> {
            while(true){
                desk.get();
            }
        }, "顾客 1").start();
        //顾客 2
        new Thread(() -> {
            while(true){
                desk.get();
            }
        }, "顾客 2").start();
    }
}
