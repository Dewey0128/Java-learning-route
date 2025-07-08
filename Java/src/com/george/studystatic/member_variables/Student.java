package com.george.studystatic.member_variables;

@SuppressWarnings("all")
public class Student {
    //类变量(一般用public修饰)
    public static String name;
    //实例变量（对象变量）
    int age;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public static String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public static void setName(String name) {
        Student.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}