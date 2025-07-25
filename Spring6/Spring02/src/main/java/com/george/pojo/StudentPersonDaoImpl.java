package com.george.pojo;

import com.george.dao.PersonDao;

public class StudentPersonDaoImpl implements PersonDao {
    @Override
    public void run() {
        System.out.println("Student");
    }
}
