package com.george.web;

import com.george.pojo.User;
import com.george.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求数据
        String username = request.getParameter("username");

        User userReslut = userService.selectByUsername(username);

        if(userReslut == null){
            response.getWriter().write("false");
        }else{
            response.getWriter().write("true");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
