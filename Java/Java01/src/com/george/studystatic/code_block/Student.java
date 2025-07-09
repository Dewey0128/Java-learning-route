package com.george.studystatic.code_block;

public class Student {

    static int number;
    static String name;
    //静态代码块在类创建时执行,且只执行一次
    static {
        System.out.println("静态代码块执行了");
        name = "zk";
    }

    int age;
    //实例代码块
    {
        System.out.println("实例代码块执行了");
        //可以用于创建日志
        System.out.println("有人创建了对象" + this);
    }

    public Student(){
        System.out.println("无参构造器执行了");
    }

    public Student(int age){
        System.out.println("有参构造器执行了");
    }
}
