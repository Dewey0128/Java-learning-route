package com.george;

import com.george.builder.Computer;
import com.george.builder.LombokComputer;

public class BuilderTest {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                                            .cpu("i9")
                                            .memory("三星")
                                            .hardDisk("三星")
                                            .monitor("三星")
                                            .build();
        System.out.println(computer);

        LombokComputer lombokComputer = LombokComputer.builder()
                .cpu("i7")
                .memory("长江存储")
                .hardDisk("凯奇")
                .monitor("小米")
                .build();
        System.out.println(lombokComputer);
    }
}
