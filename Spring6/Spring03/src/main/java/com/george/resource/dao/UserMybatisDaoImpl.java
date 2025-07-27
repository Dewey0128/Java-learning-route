package com.george.resource.dao;

import org.springframework.stereotype.Repository;

@Repository("userMybatisDaoImpl")
public class UserMybatisDaoImpl implements UserDao {
    @Override
    public void userDaoAdd() {
        System.out.println("UserMybatisDaoImpl add ...");
    }
}
