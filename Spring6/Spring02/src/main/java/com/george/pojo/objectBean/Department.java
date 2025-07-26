package com.george.pojo.objectBean;

public class Department {
    private String name;


    public String info(){
        return getName();
    }

    public Department() {
    }

    public Department(String name) {
        this.name = name;
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

    public String toString() {
        return "Department{name = " + name + "}";
    }
}
