package com.george.studyabstract.basic;

//4.一个类继承抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类
public class B extends A{
    @Override
    public void func_1() {
        System.out.println("实现A的抽象方法");
    }
}
