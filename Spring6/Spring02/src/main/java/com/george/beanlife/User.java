package com.george.beanlife;

public class User {
    private String name;

    User(){
        System.out.println("1. Bean对象创建.");
    }


    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        System.out.println("2. 给Bean对象设置属性");
        this.name = name;
    }

    public void initMethod(){
        System.out.println("4. Bean对象初始化");
    }

    public void destroyMethod(){
        System.out.println("7. Bean对象销毁");
    }

}
