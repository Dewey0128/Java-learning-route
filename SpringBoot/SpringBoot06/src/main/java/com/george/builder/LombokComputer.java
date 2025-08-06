package com.george.builder;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Builder
public class LombokComputer {
    // 电脑的组件
    private final String cpu;      // 处理器
    private final String memory;   // 内存
    private final String hardDisk; // 硬盘
    private final String graphicsCard; // 显卡
    private final String monitor;  // 显示器
}
