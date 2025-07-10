package com.george.studyinterface.example;

import java.util.ArrayList;

public class StudentOperator_2 implements StudentOperator{
    @Override
    public void printInfo(ArrayList<Student> students) {
        int male = 0, female = 0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getSex() == "男"){
                male ++;
            }else {
                female ++;
            }
            System.out.println("第" + (i + 1) + "学生：\t" + students.get(i).getName() + "\t" + students.get(i).getSex() + "\t" + students.get(i).getScore());
        }
        System.out.println("男生人数：" + male + "女生人数：" + female);
    }

    @Override
    public void printAvergeScore(ArrayList<Student> students) {
        int total = 0, max = students.get(0).getScore(), min = students.get(0).getScore();
        for (Student student : students) {
            if(student.getScore() >= max) {
                max = student.getScore();
            }else if(student.getScore() <= min) {
                min = student.getScore();
            }
            total += student.getScore();
        }
        total = total - max -min;
        System.out.println("学生平均分为：\t" + (total / (students.size() - 2)) + "\n");
    }
}
