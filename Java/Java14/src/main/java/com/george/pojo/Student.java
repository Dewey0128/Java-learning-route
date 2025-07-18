package com.george.pojo;

@SuppressWarnings("all")
public class Student {

    private int id;
    private String name;
    private int age;
    private String sex;
    private String address;
    private double math;
    private double english;
    private String hire_date;


    public Student() {
    }

    public Student(int id, String name, int age, String sex, String address, double math, double english, String hire_date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.math = math;
        this.english = english;
        this.hire_date = hire_date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public double getMath() {
        return math;
    }


    public void setMath(double math) {
        this.math = math;
    }


    public double getEnglish() {
        return english;
    }


    public void setEnglish(double english) {
        this.english = english;
    }


    public String getHire_date() {
        return hire_date;
    }


    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", age = " + age + ", sex = " + sex + ", address = " + address + ", math = " + math + ", english = " + english + ", hire_date = " + hire_date + "}";
    }
}
