package com.george.builder;

// 电脑实体类（被构建的复杂对象）
public class Computer {
    // 电脑的组件
    private final String cpu;      // 处理器
    private final String memory;   // 内存
    private final String hardDisk; // 硬盘
    private final String graphicsCard; // 显卡
    private final String monitor;  // 显示器

    // 私有构造方法，只能通过建造者创建
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.memory = builder.memory;
        this.hardDisk = builder.hardDisk;
        this.graphicsCard = builder.graphicsCard;
        this.monitor = builder.monitor;
    }

    @Override
    public String toString() {
        return "电脑配置:\n" +
                "CPU: " + cpu + "\n" +
                "内存: " + memory + "\n" +
                "硬盘: " + hardDisk + "\n" +
                "显卡: " + graphicsCard + "\n" +
                "显示器: " + monitor;
    }

    // 静态内部类：电脑建造者
    public static class Builder {
        private String cpu;      // 必须配置的组件（核心参数）
        private String memory;   // 必须配置的组件
        private String hardDisk; // 可选配置
        private String graphicsCard; // 可选配置
        private String monitor;  // 可选配置

        // 构造方法：强制设置必须的参数
        /*public Builder(String cpu, String memory) {
            this.cpu = cpu;
            this.memory = memory;
        }*/

        // 链式调用设置可选参数
        public Builder cpu(String cpu){
            this.cpu = cpu;
            return this;
        }

        public Builder memory(String memory){
            this.memory = memory;
            return this;
        }

        public Builder hardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this; // 返回自身，支持链式调用
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder monitor(String monitor) {
            this.monitor = monitor;
            return this;
        }

        // 通过以上函数,就可以让 Builder 中 this 赋值
        // 构建电脑对象
        // 直接 new 一个 Computer对象,让 Builder的this 给 Computer 赋值
        public Computer build() {
            return new Computer(this);
        }
    }
}
