package com.george.JsToJava;

import com.alibaba.fastjson.JSON;
import com.george.pojo.User;

public class JsToJava {
    public static void main(String[] args) {

        //Java ==> JSON
        User user = new User();
        user.setId(1);
        user.setUsername("坤");
        user.setPassword("121312");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);//{"id":1,"password":"121312","username":"坤"}

        //JSON ==> Java
        User u = JSON.parseObject("{\"id\":1,\"password\":\"121312\",\"username\":\"坤\"}", User.class);
        System.out.println(u);

    }
}
