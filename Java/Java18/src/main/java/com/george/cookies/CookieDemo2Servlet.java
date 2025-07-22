package com.george.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/cookieDemo2Servlet")
public class CookieDemo2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取Cookie
        Cookie[] cookies = request.getCookies();

        //遍历数组
        for (Cookie cookie : cookies) {
            if( "username".equals(cookie.getName())){
                System.out.println(cookie.getName() + ":" + URLDecoder.decode( cookie.getValue(), "utf-8"));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
