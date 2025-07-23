package com.george.web;

import com.george.pojo.Brand;
import com.george.pojo.User;
import com.george.service.BrandService;
import com.george.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/selectBrandServlet")
public class SelectBrandServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码为UTF-8（必须在获取参数前调用）
        request.setCharacterEncoding("UTF-8");
        //获取请求数据
        String brandName = request.getParameter("brandName");
        System.out.println(brandName);

        //URL解码
        byte[] bytes = brandName.getBytes(StandardCharsets.ISO_8859_1);
        brandName = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(brandName);


        Brand brandResult = brandService.selectByBrandName(brandName);

        if(brandResult == null){
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
