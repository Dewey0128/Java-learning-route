package com.george.pojo;

import com.george.dao.PersonDao;

public class TeacherPersonDaoImpl implements PersonDao {
    @Override
    public void run() {
        System.out.println("Teacher");
    }
}
