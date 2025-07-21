package com.george.web.ForwardAndRedirect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 请求转发的特点:<br>
 * * 浏览器地址栏路径不发生变化,
 *   虽然后台从`/forward01`转发到`/forward02`,但是浏览器的地址一直是`/forward01`,未发生变化<br>
 *
 * * 只能转发到当前服务器的内部资源,
 *   不能从一个服务器通过转发访问另一台服务器<br>
 *
 * * 一次请求，可以在转发资源间使用request共享数据,
 *   虽然后台从`/forward01`转发到`/forward02`，但是这个只有一次请求<br>
 * */

@WebServlet("/forward01")
public class ForwardServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Forward01");
        //存储数据
        request.setAttribute("msg","hello");
        //请求转发
        request.getRequestDispatcher("/forward02").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
