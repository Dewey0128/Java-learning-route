package com.george.pojo.collections;

import java.util.List;
import java.util.Map;

public class Student {
    private String sName;
    private int sID;
    private List<Lession> lessionList;
    private Map<String, Teacher> teacherMap;


    public void study(){
        System.out.println(getSID() +
                getSName() +
                " : 老师组：" +
                getTeacherMap() +
                " 课程组：" +
                getLessionList());
    }

    public Student() {
    }

    public Student(String sName, int sID, List<Lession> lessionList, Map<String, Teacher> teacherMap) {
        this.sName = sName;
        this.sID = sID;
        this.lessionList = lessionList;
        this.teacherMap = teacherMap;
    }

    /**
     * 获取
     * @return sName
     */
    public String getSName() {
        return sName;
    }

    /**
     * 设置
     * @param sName
     */
    public void setSName(String sName) {
        this.sName = sName;
    }

    /**
     * 获取
     * @return sID
     */
    public int getSID() {
        return sID;
    }

    /**
     * 设置
     * @param sID
     */
    public void setSID(int sID) {
        this.sID = sID;
    }

    /**
     * 获取
     * @return lessionList
     */
    public List<Lession> getLessionList() {
        return lessionList;
    }

    /**
     * 设置
     * @param lessionList
     */
    public void setLessionList(List<Lession> lessionList) {
        this.lessionList = lessionList;
    }

    /**
     * 获取
     * @return teacherMap
     */
    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    /**
     * 设置
     * @param teacherMap
     */
    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String toString() {
        return "Student{sName = " + sName + ", sID = " + sID + ", lessionList = " + lessionList + ", teacherMap = " + teacherMap + "}";
    }
}
