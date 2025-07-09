package com.george.polymorphic.attention;

public class Test {
    public static void main(String[] args) {
        //1.目标 ：多态弊端
        People p1 = new Teacher();
        p1.run();

        //2.多态下纯在的问题，无法直接调用子类的独有功能
        //p1.teach();

        @SuppressWarnings("all")
        //3.解决方法：强制类型转换
        Teacher t1 = (Teacher)p1;
        t1.teach();

        //4.强制转换可能存在的问题：编译阶段有继承或者实现关系就可以强制转换，但是运行时可能出现类型转换异常
        try{
            Student s1 = (Student) p1;  //运行时：出现ClassCastException异常
        } catch (Exception e) {
            e.printStackTrace();
        }


        //5.可能避免ClassCastException的方法：使用instanceof关字，判断当前对象的真实类型再进行强转。
        if(p1 instanceof Student){
            Student s2 = (Student) p1;
            s2.test();
        }else if(p1 instanceof Teacher){
            Teacher t2 = (Teacher) p1;
            t2.teach();
        }

        System.out.println("--------------");
        Student s = new Student();
        go(s);

        Teacher t = new Teacher();
        go(t);
    }

    public static void go(People p1){
        p1.run();
        if(p1 instanceof Student){
            Student s2 = (Student) p1;
            s2.test();
        }else if(p1 instanceof Teacher){
            Teacher t2 = (Teacher) p1;
            t2.teach();
        }
    }
}
