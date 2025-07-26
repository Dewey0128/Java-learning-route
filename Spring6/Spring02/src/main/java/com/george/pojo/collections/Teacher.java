package com.george.pojo.collections;

public class Teacher {
    private String tName;
    private int tId;


    public Teacher() {
    }

    public Teacher(String tName, int tId) {
        this.tName = tName;
        this.tId = tId;
    }

    /**
     * 获取
     * @return tName
     */
    public String getTName() {
        return tName;
    }

    /**
     * 设置
     * @param tName
     */
    public void setTName(String tName) {
        this.tName = tName;
    }

    /**
     * 获取
     * @return tId
     */
    public int getTId() {
        return tId;
    }

    /**
     * 设置
     * @param tId
     */
    public void setTId(int tId) {
        this.tId = tId;
    }

    public String toString() {
        return "Teacher{tName = " + tName + ", tId = " + tId + "}";
    }
}
