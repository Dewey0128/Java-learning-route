package com.george.jdbchomework;

public enum Choose {
    CHAXUN("查询"), TIANJIA("添加"), XIUGAI("修改"), SHANCHU("删除");

    private final String desc; // 操作描述，方便用户理解

    Choose(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
