package com.george.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserMybatisDaoImpl implements UserDao{
    @Override
    public void userDaoAdd() {
        System.out.println("UserMybatisDaoImpl add ...");
    }
}
