package com.george.templatemode;

public class Teacher extends People{
    public Teacher() {
    }

    @Override
    public String getName(){
        return "老师";
    }

    @Override
    public void pwrite(){
        System.out.println("    老师编写的正文。");
    }
}
