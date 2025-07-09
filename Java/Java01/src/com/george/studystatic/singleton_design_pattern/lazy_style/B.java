package com.george.studystatic.singleton_design_pattern.lazy_style;

//懒汉式单例模式
public class B {
    //2.定义一个类变量但不用记住对象
    private static B b;

    //1.必须私有类的构造器
    private B(){}

    //3.定义一个类方法返回类的对象
    public static B getB(){
        if( b == null ){
            b = new B();
        }
        return b;
    }
}
