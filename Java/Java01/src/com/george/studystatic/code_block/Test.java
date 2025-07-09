package com.george.studystatic.code_block;

public class Test {
    public static void main(String[] args) {
        System.out.println(Student.name);
        System.out.println(Student.name);
        System.out.println(Student.name);

        System.out.println("------------------------------");
        Student s1 = new Student();
        Student s2 = new Student(19);
        System.out.println(s1.age);
        System.out.println(s2.age);
    }
}
