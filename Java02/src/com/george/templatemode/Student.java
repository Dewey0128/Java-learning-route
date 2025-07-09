package com.george.templatemode;

public class Student extends People{
    public Student() {
    }

    @Override
    public String getName(){
        return "学生";
    }

    @Override
    public void  pwrite(){
        System.out.println("    学生编写的正文。");
    }

}
