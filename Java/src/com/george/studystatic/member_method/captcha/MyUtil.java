package com.george.studystatic.member_method.captcha;

import java.util.Random;
/**
类方法的常见应用场景。
    类方法最常见的应用场景是做工具类。
工具类是什么？
    工具类中的方法都是一些类方法，每个方法都是用来完成一个功能的，工具类是给开发人员共同使用的。
*/
public class MyUtil {

    //工具类没有创建对象的需求，建议将工具类的构造器进行私有。
    private MyUtil() {}

    public static String createCode(int n){
        StringBuilder code = new StringBuilder();
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        Random r = new Random();
        //2.开始定义一个循环产生每位随机字符
        for (int i = 0; i < n; i++) {
            //3.随机一个字符范围内的索引
            int index = r.nextInt(data.length());
            //4.根据索引去取字符
            code.append(data.charAt(index));
        }
        return code.toString();
    }
}
