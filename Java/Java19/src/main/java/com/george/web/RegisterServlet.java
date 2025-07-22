package com.george.web;

import com.george.pojo.User;
import com.george.service.BrandService;
import com.george.service.UserService;
import com.george.util.SqlSessionFactoryUtils;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    // 密码正则：8-20位，包含至少一个字母和一个数字
    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在转发前设置响应编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

        // 程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        // 比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){

            request.setAttribute("checkCode_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            // 不允许注册
            return;
        }

        //获取页面数据
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        System.out.println(user);

        //调用 UserService 查询
        if(userService.selectByUsername(user.getUsername()) != null){
            //声明数据库存在该用户不让登入
            request.setAttribute("username_register_msg", "用户名已存在！");
            //跳转，转发到register.jsp页面
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }else if(user.getPassword() == null || !user.getPassword().matches(PASSWORD_REGEX)){
            request.setAttribute("password_register_msg", "密码需8-20位，包含字母和数字");
            request.getRequestDispatcher("register.jsp").forward(request, response);

        }else{
            if (userService.add(user)) {
                //创建Session
                //将用户信息存储到Session
                session.setAttribute("user", user);

                request.setAttribute("register_msg","注册成功，请登录");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                request.setAttribute("register_msg", "注册失败！");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
