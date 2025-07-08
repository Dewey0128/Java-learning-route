package com.george.studystatic.member_variables;

/*
* 类变量的应用场景
*       在开发中，如果某个数据只需要一份，且希望能够被共享（访问，修改），则该数据可以定义成类变量来记住
* */

@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {
        //1.类变量用法
        //类变量 ： 属于类,与类一起加载一次，在内存中只有一份，可以被类和类的所有对象共享
        //类名.类变量（推荐）
        Student.name = "zk";
        System.out.println("Student.类变量:" + Student.name);

        //对象.类变量（不推荐）
        Student s1 = new Student();
        s1.name = "tjj";
        System.out.println("s1.类变量:" + s1.name);

        Student s2 = new Student();
        s2.name = "123";
        System.out.println("s2.类变量:" + s2.name);

        System.out.println("Student.类变量:" + Student.name);

        //2.实例变量用法
        //实例变量 ： 属于对象, 每个对象都有一份，只能用对象访问
        //对象.实例变量
        s1.age = 18;
        System.out.println("s1.实例变量：" + s1.age);
        s2.age = 19;
        System.out.println("s2.实例变量：" + s2.age);
    }
}