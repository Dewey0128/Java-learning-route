package com.george.autowired.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void userDaoAdd() {
        System.out.println("UserDaoImpl add ...");
    }
}
