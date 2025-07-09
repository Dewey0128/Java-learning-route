package com.george.templatemode;

public abstract class People {
    public String name;

    public void write(){
        System.out.println("\t\t\t\t题目");
        System.out.println("作者名：" + getName());
        pwrite();
        System.out.println("\t\t\t\t\t\t\t  年  月  日");
    }

    public String getName(){
        return "";
    }

    public abstract void pwrite();

}
