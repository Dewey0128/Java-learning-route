package com.george.startup;

import com.george.mapper.BrandMapper;
import com.george.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisCase {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis的核心配置文件, 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取SqlSession对象, 用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.1 执行sql
        //List<Student> students = sqlSession.selectList("test.selectAllStudent");
        // 3.2 获取StudentMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        Brand brand = brandMapper.searchByIdBrand(1);

        System.out.println(brand);
        System.out.println(brands);

        //4. 释放资源
        sqlSession.close();
    }
}
