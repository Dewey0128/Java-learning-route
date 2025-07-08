package com.george.studystatic.member_method.captcha;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("验证码位数:");
        int n = sc.nextInt();

        System.out.println("生成的" + n + "位验证码为：" + MyUtil.createCode(n));
    }
}
