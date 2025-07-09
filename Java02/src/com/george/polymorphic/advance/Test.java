package com.george.polymorphic.advance;

public class Test {
    public static void main(String[] args) {
        //目标 ：理解多态的好处
        //好处1：可以实现解耦合，右边对象可以随时切换，后续业务随机应变
        //一辆车可以换轮子，换发动机
        People p1 = new Teacher();
        p1.run();

        //好处2：可以使用父类类型的变量作为形参，可以接收一切子类对象
        Student s = new Student();
        go(s);

        Teacher t = new Teacher();
        go(t);
    }

    public static void go(People p){

    }
}
