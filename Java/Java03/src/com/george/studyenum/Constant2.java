package com.george.studyenum;

@SuppressWarnings("all")
public enum Constant2 {
    //1.枚举类的第一行只能罗列一些名称,这些名称都是常量并且每个常量记住的都是枚举类的一个对象。
    BOY, GIRL,
    TEST("测试"){

    };

    //2.枚举类中，从第二行开始，可以定义类的其他各种成员。
    private String name;

    //3.枚举类的构造器都是私有的（写不写都只能是私有的），因此，枚举类对外不能创建对象。
    Constant2() {
    }

    Constant2(String name) {
        this.name = name;
    }

    //4.枚举都是最终类,不可以被继承。
    /*Constant2(Constant2 BOY, Constant2 GIRL) {
        this.BOY = BOY;
        this.GIRL = GIRL;
    }*/

    public String toString() {
        return this.name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
