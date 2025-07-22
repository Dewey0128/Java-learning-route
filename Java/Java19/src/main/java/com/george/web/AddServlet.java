package com.george.web;

import com.george.pojo.Brand;
import com.george.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private  BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在浏览器端获取数据
        //1. 解决乱码：POST，getReader()
        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码
        //获取字符输出流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        Brand brand = new Brand();
        System.out.println("-----getParameter()方法获取单个值-------");
/*        //2. 获取所有参数的Map集合
        Map<String, String[]> map = request.getParameterMap();
        System.out.println("-----getParameterMap()方法获取所有键值对-------");
        for (String key : map.keySet()) {
            // username:zhangsan lisi
            System.out.print(key+":");
            //获取值3
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }*/
        brand.setBrandName(request.getParameter("brandName"));
        brand.setCompanyName(request.getParameter("companyName"));
        brand.setOrdered( Integer.parseInt(request.getParameter("ordered")));
        brand.setDescription(request.getParameter("description"));
        brand.setStatus(Integer.parseInt(request.getParameter("status")));

        if(service.selectByBrandName(brand.getBrandName()) != null){
            writer.write("该企业已存在！请重新输入！");
        }else{
            System.out.println(brand);
            service.add(brand);
            request.getRequestDispatcher("/selectAllServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
