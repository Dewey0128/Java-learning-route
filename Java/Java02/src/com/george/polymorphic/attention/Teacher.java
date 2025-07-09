package com.george.polymorphic.attention;

public class Teacher extends People {
    public String name = "子类Teacher";

    @Override
    public void run() {
        System.out.println("老师跑得慢！");
    }

    public void teach(){
        System.out.println("老师类特有功能");
    }
}
