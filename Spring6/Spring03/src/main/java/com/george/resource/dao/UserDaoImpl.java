package com.george.resource.dao;


import org.springframework.stereotype.Repository;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Override
    public void userDaoAdd() {
        System.out.println("UserDaoImpl add ...");
    }
}
