package com.george.polymorphic.advance;

public class Student extends People {
    public String name = "子类Student";

    @Override
    public void run() {
        System.out.println("学生跑得快！");
    }
}
