package com.george.sessions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/sessionDemo2Servlet")
public class SessionDemo2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session数据
        HttpSession session = request.getSession();

        //从Cookie中获取到JSSESSIONID JSESSIONID=97B82B7065ACA894C472638947BC5000
        System.out.println(session.getAttribute("name"));

        //删除Session中的值:根据key，删除键值对
        //void removeAttribute(String name);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
