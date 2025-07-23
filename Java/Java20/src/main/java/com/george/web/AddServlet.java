package com.george.web;

import com.alibaba.fastjson.JSON;
import com.george.pojo.Brand;
import com.george.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据， request.getParameter 不能接收 JSON 的数据
        //System.out.println(request.getParameter("brandName"));

        //获取请求体数据
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        //将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);

        //调用brandService 使用add 方法
        brandService.add(brand);

        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
