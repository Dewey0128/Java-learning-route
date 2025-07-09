package com.george.polymorphic.advance;

public class Teacher extends People {
    public String name = "子类Teacher";

    @Override
    public void run() {
        System.out.println("老师跑得慢！");
    }
}
