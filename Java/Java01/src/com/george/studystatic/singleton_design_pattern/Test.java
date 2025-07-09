package com.george.studystatic.singleton_design_pattern;

import com.george.studystatic.singleton_design_pattern.hungry_man_style.A;
import com.george.studystatic.singleton_design_pattern.lazy_style.B;

public class Test {
    public static void main(String[] args) {
        System.out.println("饿汉式单例模式:");
        System.out.println(A.getA());
        System.out.println(A.getA());
        System.out.println(A.getA());
        System.out.println("懒汉式单例模式:");
        System.out.println(B.getB());
        System.out.println(B.getB());
        System.out.println(B.getB());
    }
}
