package com.george.jdbcDruid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DruidTest {
    public static void main(String[] args) throws Exception {
        //1. 导入jar包

        //2. 定义配置文件

        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:/Java/Java_learning_route/Java/Java12/src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5. 获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        String sql = "select * from student where name like '%十%'";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            // 假设表中有id, name, address等字段
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("address");

            System.out.printf("ID: %d, 姓名: %s, 地址: %s%n", id, name, address);
        }
        //System.out.println(System.getProperty("user.dir"));
        System.out.println(connection);
    }
}
