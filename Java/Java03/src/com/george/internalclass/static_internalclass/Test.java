package com.george.internalclass.static_internalclass;

import com.george.internalclass.static_internalclass.Car;

public class Test {
    public static void main(String[] args) {
        //成员内部类声明：Car.Engine c = new Car().new Engine();
        Car.Engine c = new Car.Engine();
        c.test();
    }
}
