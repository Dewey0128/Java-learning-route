package com.george.studyinterface.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentOperator_1 implements StudentOperator{
    @Override
    public void printInfo(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("第" + (i + 1) + "学生：\t" + students.get(i).getName() + "\t" + students.get(i).getSex() + "\t" + students.get(i).getScore());
        }
    }

    @Override
    public void printAvergeScore(ArrayList<Student> students) {
        int total = 0;
        for (Student student : students) {
            total += student.getScore();
        }
        System.out.println("学生平均分为：\t" + (total / students.size()) + "\n");
    }
}
