package com.george.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookieDemo1Servlet")
public class CookieDemo1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用Cookie
        //1.创建Cookie
        //Cookie cookie = new Cookie("username", "zk");
        //1.1传输中文Cookie
        String value = "周坤";
        //1.2使用URL编码
        value = URLEncoder.encode(value, "utf-8");
        //1.3重新创建Cookie
        Cookie cookie = new Cookie("username", value);

        //设置存活时间 秒为单位
        cookie.setMaxAge(60*60*24);

        //2.发送Cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
