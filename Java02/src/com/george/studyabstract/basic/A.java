package com.george.studyabstract.basic;

public abstract class A {
    //1.抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类
    public abstract void func_1();

    //2.类该有的成员（成员变量，方法，构造器）抽象类都可以有
    private String name;

    public void func_2(){
        System.out.println("成员方法");
    }

    public A(){

    }

}
