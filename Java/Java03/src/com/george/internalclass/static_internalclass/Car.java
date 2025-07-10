package com.george.internalclass.static_internalclass;

import com.sun.xml.internal.ws.api.pipe.Engine;

public class Car {
    private final int speed = 99;
    private static String name = "Car";

    public static class Engine {
        private String Manufacturers;
        private int speed = 88;


        public Engine() {
        }

        public void test(){
            int speed = 77;
            System.out.println(speed);
            System.out.println(this.speed);
            //System.out.println(Car.this.speed); //报错：静态内部类无法访问外部类的成员变量
            System.out.println(Car.name);
        }

        public Engine(String Manufacturers, int speed) {
            this.Manufacturers = Manufacturers;
            this.speed = speed;
        }

        /**
         * 获取
         * @return Manufacturers
         */
        public String getManufacturers() {
            return Manufacturers;
        }

        /**
         * 设置
         * @param Manufacturers
         */
        public void setManufacturers(String Manufacturers) {
            this.Manufacturers = Manufacturers;
        }

        /**
         * 获取
         * @return speed
         */
        public int getSpeed() {
            return speed;
        }

        /**
         * 设置
         * @param speed
         */
        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public String toString() {
            return "engine{Manufacturers = " + Manufacturers + ", speed = " + speed + "}";
        }
    }
}
