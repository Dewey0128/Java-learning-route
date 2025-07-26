package com.george.pojo.collections;

public class Lession {
    private String lName;
    private int lId;

    public Lession() {
    }

    public Lession(String lName, int lId) {
        this.lName = lName;
        this.lId = lId;
    }

    /**
     * 获取
     * @return lName
     */
    public String getLName() {
        return lName;
    }

    /**
     * 设置
     * @param lName
     */
    public void setLName(String lName) {
        this.lName = lName;
    }

    /**
     * 获取
     * @return lId
     */
    public int getLId() {
        return lId;
    }

    /**
     * 设置
     * @param lId
     */
    public void setLId(int lId) {
        this.lId = lId;
    }

    public String toString() {
        return "Lession{lName = " + lName + ", lId = " + lId + "}";
    }
}
