package com.george.studyenum;

public class Test {
    public static void main(String[] args) {
        //认识枚举
        Constant2 constant2 = Constant2.BOY;
        System.out.println(constant2);

        //枚举类对外不能创建对象
        //Constant2 c = new Constant2();

        //枚举常用API
        Constant2[] as = Constant2.values(); //拿到全部对象
        for (Constant2 a : as) {
            System.out.println(a);
        }

        System.out.println("---------------------------");

        check(Constant.BOY);
        //枚举 ：掌握枚举的应用场景，做信息标志和分类
        check(Constant2.GIRL);

    }
    public static void check(int sex){
        switch (sex){
            case Constant.BOY:
                System.out.println("常量：男生");
                break;
            case Constant.GIRL:
                System.out.println("常量：女生");
                break;
        }
    }

    public static void check(Constant2 sex){
        switch (sex){
            case BOY:
                System.out.println("枚举：男生");
                break;
            case GIRL:
                System.out.println("枚举：女生");
                break;
        }
    }
}
