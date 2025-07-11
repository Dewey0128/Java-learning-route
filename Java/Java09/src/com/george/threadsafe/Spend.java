package com.george.threadsafe;

public class Spend extends Thread{

    Account acc;

    public Spend(Account acc, String name) {
        super(name);
        this.acc = acc;
    }

    public void run(){
        acc.spendmoney(10000);
    }
}
