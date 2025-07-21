package com.george.web.ForwardAndRedirect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/redirect01")
public class RedirectServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("redirect01....");
        //重定向
        //1.设置响应状态码 302
        /*response.setStatus(302);
        //2. 设置响应头 Location
        response.setHeader("Location","/Tomcat/redirect02");*/
        //简化
        //重定向
        response.sendRedirect("/Tomcat/redirect02");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
