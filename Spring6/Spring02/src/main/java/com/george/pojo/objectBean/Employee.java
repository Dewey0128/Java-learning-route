package com.george.pojo.objectBean;

public class Employee {
    private String name;
    private int age;
    private Department department;

    public void work(){

        System.out.println(getName() + " " + getAge() + " :在" + this.department.info());
    }

    public Employee() {
    }

    public Employee(String name, int age, Department department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * 获取
     * @return department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * 设置
     * @param department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    public String toString() {
        return "Employee{name = " + name + ", age = " + age + ", department = " + department + "}";
    }
}
