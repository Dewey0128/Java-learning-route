package com.george.web.ReqAndRes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String getMethod()：获取请求方式： GET
        System.out.println("getMethod()方法：" + request.getMethod());
        // String getContextPath()：获取虚拟目录(项目访问路径)：/Tomcat
        System.out.println("getContextPath方法：" + request.getContextPath());
        // StringBuffer getRequestURL(): 获取URL(统一资源定位符)：http://localhost:8080/Tomcat/req
        StringBuffer url = request.getRequestURL();
        System.out.println("getRequestURL()方法：" + url.toString());
        // String getRequestURI()：获取URI(统一资源标识符)： /Tomcat/req
        String uri = request.getRequestURI();
        System.out.println("getRequestURL()方法：" + uri);
        // String getQueryString()：获取请求参数（GET方式）： username=admin&password=admin&hobby=1&hobby=2
        System.out.println("getQueryString()方法：" + request.getQueryString());
        //获取请求头: user-agent: 浏览器的版本信息
        String agent = request.getHeader("user-agent");
        System.out.println("user-agent: 浏览器的版本信息：" + agent);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        //获取post 请求体：请求参数
        //1. 获取字符输入流
        BufferedReader br = request.getReader();
        //2. 读取数据
        String line = br.readLine();
        System.out.println(line);
    }
}
