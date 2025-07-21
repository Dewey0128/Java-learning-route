package com.george.web.LoginRegisterCase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import com.george.mapper.UserMapper;
import com.george.pojo.User;
import com.george.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----getParameter()方法获取单个值-------");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        /*// 1. 加载mybatis的核心配置文件, 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/

        //优化上三行代码
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        // 2. 获取SqlSession对象, 用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.1 执行sql
        //List<Student> students = sqlSession.selectList("test.selectAllStudent");
        // 3.2 获取StudentMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User users= userMapper.search(user);
        System.out.println(users);


        //获取字符输出流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if(users != null ){
            //登入成功
            writer.write("账号已存在，请返回重新输入！");
        }else{
            //登入失败
            int i = userMapper.insert(user);
            sqlSession.commit();
            if( i == 1){
                writer.write("创建成功！");
            }else writer.write("创建失败！");
        }
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
