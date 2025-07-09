package com.george.studystatic.member_method;

public class Student {
    private double score;

    public Student() {
    }

    public Student(double score) {
        this.score = score;
    }

    //类方法 ： 有static修饰，属于类
    public static void printHelloWorld(){
        System.out.println("Hello World");
    }

    //实例方法 ：对象方法
    public void printPass(){
        System.out.println("成绩：" +
                ((this.score >= 60) ? "及格" : "不及格"));
    }

    /**
     * 获取
     * @return score
     */
    public double getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(double score) {
        this.score = score;
    }

    public String toString() {
        return "Student{score = " + score + "}";
    }
}
