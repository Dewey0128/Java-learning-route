package com.george.threadsafe;

public class Test {
    public static void main(String[] args) {
        Account acc = new Account("ICBC-0128", 10000);
        Thread t1 = new Spend(acc, "小明");
        Thread t2 = new Spend(acc, "小红");
        t1.start();
        t2.start();
    }
}
