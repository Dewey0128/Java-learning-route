package com.george.web.ServletStudy;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(urlPatterns="/demo1",loadOnStartup = 1)
public class ServletDemo1 implements Servlet {
    /**
     * 初始化方法
     * 1. 调用时机：默认情况下，Servlet被第一次访问时，调用
     *      * loadOnStartup:
     * 2. 调用次数：1次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 提供服务
     * 1. 调用时机：每一次Servlet被访问时，调用
     * 2. 调用次数：多次
     *
     *
     * @param servletResponse
     * @param servletRequest
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 根据请求方式的不同，进行分别的处理

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //1. 获取请求方式
        String method = request.getMethod();
        //2. 判断
        if("GET".equals(method)){
            System.out.println("get方式的处理逻辑");
        }else if("POST".equals(method)){
            System.out.println("post方式的处理逻辑");
        }
    }

    /**
     * 销毁方法
     * 1. 调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁，调用
     * 2. 调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }


}
