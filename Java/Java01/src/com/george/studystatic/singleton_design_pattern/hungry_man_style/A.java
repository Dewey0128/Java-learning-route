package com.george.studystatic.singleton_design_pattern.hungry_man_style;

//饿汉式单例模式
public class A {
    //2.定义一个类变量记住类的一个对象
    private static A a = new A();

    //1.必须私有类的构造器
    private A(){}

    //3.定义一个类方法返回类的对象
    public static A getA(){
        return a;
    }
}
