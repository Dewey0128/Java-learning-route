package com.george.polymorphic.basic;

public class Test {
    public static void main(String[] args) {
        //目标 ：认识多态，对象多态，行为多态
        //1.对象多态
        People p1 = new Teacher();
        //2.行为多态，编译看左边，运行看右边
        p1.run();
        //3.注意：对于变量，编译看左边，运行看左边
        System.out.println(p1.name);

        System.out.println("----------------------------");

        People p2 = new Student();
        p2.run();
        System.out.println(p2.name);
    }
}
