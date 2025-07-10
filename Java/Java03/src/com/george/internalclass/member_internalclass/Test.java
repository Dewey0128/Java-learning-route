package com.george.internalclass.member_internalclass;

public class Test {
    public static void main(String[] args) {
        Car.Engine c = new Car().new Engine();
        c.test();
    }
}
