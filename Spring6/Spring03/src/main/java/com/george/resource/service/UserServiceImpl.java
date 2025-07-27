package com.george.resource.service;

import com.george.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class UserServiceImpl implements UserService {
    //注入Dao
    /*// 第一种方式 属性注入
    @Autowired  // 根据类型(byType)找到对应对象， 完成注入
    @Qualifier("userMybatisDaoImpl") // byName，根据名称进行装配了*/
    @Resource
    private UserDao userMybatisDaoImpl;

    @Override
    public void userServiceAdd() {
        System.out.println("UserServiceImpl add ...");
        userMybatisDaoImpl.userDaoAdd();
    }
}
