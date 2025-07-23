package com.george.service;

import com.george.mapper.UserMapper;
import com.george.pojo.User;
import com.george.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User select(User user){
        SqlSession sqlSession = factory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用 userMapper 的 select 方法
        User userResult = userMapper.select(user.getUsername(), user.getPassword());

        //关闭连接
        sqlSession.close();

        return userResult;
    }

    public User selectByUsername(String username){
        SqlSession sqlSession = factory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用 userMapper 的 selectByUsername 方法
        User userResult = userMapper.selectByUsername(username);

        sqlSession.close();

        return userResult;
    }

    public boolean add(User user){
        SqlSession sqlSession = factory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        boolean success = userMapper.add(user);

        sqlSession.commit();
        sqlSession.close();

        return success;
    }
}
