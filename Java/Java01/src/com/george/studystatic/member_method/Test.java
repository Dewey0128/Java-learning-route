package com.george.studystatic.member_method;

public class Test {
    public static void main(String[] args) {
        //1.类方法用法
        //类名.类方法（推荐）
        Student.printHelloWorld();

        //对象.类方法（不推荐）
        Student s = new Student();

        //2.实例方法用法
        //对象.实例方法
        s.setScore(59);
        s.printPass();
    }
}
