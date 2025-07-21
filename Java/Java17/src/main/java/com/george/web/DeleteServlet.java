package com.george.web;

import com.george.pojo.Brand;
import com.george.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在浏览器端获取数据
        // 1. 解决乱码：POST，getReader()
        request.setCharacterEncoding("UTF-8");// 设置字符输入流的编码
        // 获取字符输出流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        // 获取 isConfirmed 参数
        String isConfirmedStr = request.getParameter("isConfirmed");
        boolean isConfirmed = Boolean.parseBoolean(isConfirmedStr);

        if (isConfirmed) {
            // 用户点击了确定，执行删除逻辑
            String idStr = request.getParameter("id");
            int id = Integer.parseInt(idStr);
            // 调用删除方法
            boolean isDeleted = service.delectById(id);
            if (isDeleted) {
                request.getRequestDispatcher("/selectAllServlet").forward(request, response);
                writer.println("品牌删除成功！");
            } else {
                writer.println("品牌删除失败！");
            }
        } else {
            // 用户点击了取消
            writer.println("操作已取消！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
