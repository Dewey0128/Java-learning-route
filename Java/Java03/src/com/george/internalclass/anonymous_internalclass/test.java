package com.george.internalclass.anonymous_internalclass;

public class test {
    public static void main(String[] args) {

        //常规定义
        System.out.println("\n----------1.常规定义形式---------------\n");
        Animal cat = new Cat();
        cat.swim();

        //匿名内部类的定义
        System.out.println("\n--------2.匿名内部类定义形式------------\n");
        Animal dog = new Animal() {
            @Override
            public void swim() {
                System.out.println("🐕🏊‍");
            }
        };
        dog.swim();

        //常常以传参的参数形式
        System.out.println("\n--------3.常常以传参的参数形式----------\n");
        go(new Animal() {
            @Override
            public void swim() {
                System.out.println("参数形式🏊‍");
            }
        });

    }

    public static void go(Animal a){
        a.swim();
    }
}

class Cat implements Animal {
    @Override
    public void swim() {
        System.out.println("🐱🏊‍");
    }
}

interface Animal{
    default void swim(){

    }
}
