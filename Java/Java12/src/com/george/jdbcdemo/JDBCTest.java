package com.george.jdbcdemo;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        //注册jar包，MySQL驱动,可以不写
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://localhost:3306/mysqlbase";
        String user = "root";
        String password = "@Poole0128";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             //定义SQL语句,获取执行SQL对象
             ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE address LIKE '%四川%'")) { // 修正SQL语法

            // 处理查询结果
            while (rs.next()) {
                // 假设表中有id, name, address等字段
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");

                System.out.printf("ID: %d, 姓名: %s, 地址: %s%n", id, name, address);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 打印异常信息
        }
    }
}
