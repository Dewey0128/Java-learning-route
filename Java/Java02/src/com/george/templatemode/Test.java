package com.george.templatemode;

public class Test {
    public static void main(String[] args) {
        People t = new Teacher();
        People s = new Student();

        t.write();
        System.out.println("----------------------------------------");
        s.write();
    }
}
