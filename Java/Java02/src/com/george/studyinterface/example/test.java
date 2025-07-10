package com.george.studyinterface.example;

public class test {
    public static void main(String[] args) {
        ClassManager cm = new ClassManager();
        System.out.println("-----------显示学生信息-------------\n");
        cm.printInfo();
        System.out.println("\n-------------打印平均分--------------\n");
        cm.printAvergeScore();
    }
}
