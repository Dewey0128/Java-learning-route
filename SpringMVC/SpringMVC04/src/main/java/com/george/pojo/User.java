package com.george.pojo;

import java.util.Arrays;

public class User {
    private String username;
    private String password;
    private Integer sex;
    private String[] interest;
    private String info;


    public User() {
    }

    public User(String username, String password, Integer sex, String[] interest, String info) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.interest = interest;
        this.info = info;
    }


    /**
     * 设置
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }



    /**
     * 设置
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }



    /**
     * 设置
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }



    /**
     * 设置
     * @param interest 兴趣
     */
    public void setInterest(String[] interest) {
        this.interest = interest;
    }



    /**
     * 设置
     * @param info 简介
     */
    public void setInfo(String info) {
        this.info = info;
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + ", sex = " + sex + ", interest = " + Arrays.toString(interest) + ", info = " + info + "}";
    }
}
