package com.george.jdbchomework;

import java.security.PublicKey;
import java.sql.*;
import java.util.Scanner;

/**
 * 完成商品品牌数据的增删改查操作
 *
 * * 查询：查询所有数据
 * * 添加：添加品牌
 * * 修改：根据id修改
 * * 删除：根据id删除*/
public class Test {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mysqlbase";
        String user = "root";
        String password = "@Poole0128";

        // 2. 用户自主选择操作（枚举标记）
        Choose userChoose = getUserChoose();
        // 3. 执行用户选择的操作
        try (Connection conn = DriverManager.getConnection(url, user, password)) { // 自动关闭连接
            pick(conn, userChoose);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 2. 让用户自主选择枚举标记（核心：用户输入 -> 映射为枚举）
    private static Choose getUserChoose() {
        Scanner sc = new Scanner(System.in);
        // 展示可选操作
        System.out.println("请选择操作：");
        Choose[] chooses = Choose.values();
        for (int i = 0; i < chooses.length; i++) {
            System.out.printf("%d. %s%n", i + 1, chooses[i].getDesc());
        }

        // 循环直到用户输入有效
        while (true) {
            System.out.print("请输入操作序号（1-" + chooses.length + "）：");
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input >= 1 && input <= chooses.length) {
                    return chooses[input - 1]; // 映射为枚举（序号-1对应数组索引）
                } else {
                    System.out.println("输入无效，请重新输入！");
                }
            } catch (NumberFormatException e) {
                System.out.println("请输入数字！");
            }
        }
    }

    public static void pick (Connection conn, Choose choose) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql;
        Scanner sc = new Scanner(System.in);
        switch (choose){
            case CHAXUN:
                sql = "select * from tb_brand";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    int id = rs.getInt("id");
                    String brand_name = rs.getString("brand_name");
                    String company_name = rs.getString("company_name");
                    int ordered = rs.getInt("ordered");
                    String desc = rs.getString("description");
                    int status = rs.getInt("status");

                    System.out.printf("ID:%d,品牌名：%s,公司名：%S,排名：%d,描述：%s,状态：%d\n",
                            id,brand_name,company_name,ordered,desc,status);
                }
            case TIANJIA:
                String name = sc.next();
                sql = "insert into tb_brand (company_name) values ('" + name + "');";
                int count = stmt.executeUpdate(sql);
                if(count > 0){
                    System.out.println("插入成功");
                }else System.out.println("插入失败");
            case XIUGAI:
                System.out.print("请输入要修改的品牌ID：");
                int updateId = sc.nextInt();
                sc.nextLine(); // 消费换行符
                System.out.print("请输入新的品牌名：");
                String newBrandName = sc.nextLine();
                sql = String.format("update tb_brand set brand_name = '%s' where id = %d",
                        newBrandName, updateId);
                int updateRows = stmt.executeUpdate(sql);
                System.out.println(updateRows > 0 ? "修改成功" : "修改失败");
                break;
            case SHANCHU:
                System.out.print("请输入要删除的品牌ID：");
                int deleteId = sc.nextInt();
                sql = "delete from tb_brand where id = " + deleteId;
                int deleteRows = stmt.executeUpdate(sql);
                System.out.println(deleteRows > 0 ? "删除成功" : "删除失败");
                break;

            default:
                System.out.println("无效操作");
        }
    }
}
