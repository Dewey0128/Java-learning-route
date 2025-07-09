package com.george.polymorphic.attention;

public class Student extends People {
    public String name = "子类Student";

    @Override
    public void run() {
        System.out.println("学生跑得快！");
    }

    public void test(){
        System.out.println("学生类特有功能");
    }
}
