package com.george.web;

import com.george.pojo.User;
import com.george.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在转发前设置响应编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        //获取页面传入的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        //创建User对象接收参数
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(user);

        //调用服务层，查询数据
        User userResult = userService.select(user);

        if(userResult != null){
            //判断是否要写入Cookie
            if("1".equals(remember)){
                //创建Cookie
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                //设置存活时间
                c_username.setMaxAge(60*60*24);
                c_password.setMaxAge(60*60*24);

                //发送Cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            //将用户信息存储到Session
            HttpSession session = request.getSession();
            session.setAttribute("user", userResult);

            //动态获取路径
            String contextPath = request.getContextPath();

            //并且重定向到查询页面
            response.sendRedirect(contextPath+ "/selectAllServlet");
        }else {
            //登入失败

            //存储错误信息到request
            request.setAttribute("login_msg", "用户名或密码错误！");

            //跳转，转发到login.jsp页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
