package com.george.studyinterface.example;

import com.george.studyabstract.basic.A;

import java.util.ArrayList;

public class ClassManager {
    private ArrayList<Student> students = new ArrayList<>();

    private StudentOperator studentOperator_1 = new StudentOperator_1();
    private StudentOperator studentOperator_2 = new StudentOperator_2();

    public ClassManager(){
        students.add(new Student("马尔扎哈","男",122));
        students.add(new Student("阿达大费","男",102));
        students.add(new Student("迪丽热巴","女",90));
        students.add(new Student("古力娜扎","女",82));
    }

    public void printInfo(){
        System.out.println("\n----------------方案一--------------\n");
        studentOperator_1.printInfo(students);
        System.out.println("\n----------------方案二--------------\n");
        studentOperator_2.printInfo(students);
    }

    public void printAvergeScore(){
        System.out.println("\n----------------方案一--------------\n");
        studentOperator_1.printAvergeScore(students);
        System.out.println("\n------------  --方案二--------------\n");
        studentOperator_2.printAvergeScore(students);
    }


}
