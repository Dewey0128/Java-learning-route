package com.george.startup;

import com.george.mapper.BrandMapper;
import com.george.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MyBatisCase {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis的核心配置文件, 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取SqlSession对象, 用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.1 执行sql
        //List<Student> students = sqlSession.selectList("test.selectAllStudent");
        // 3.2 获取StudentMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand getBrand = new Brand();
        getBrand.setStatus(status);
        getBrand.setCompanyName(companyName);
        getBrand.setBrandName(brandName);

        //使用Map存储参数
        Map<Object, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        /*查询语句*/
/*        //1.
        List<Brand> brands = brandMapper.selectAll();
        //2.
        Brand brand = brandMapper.searchByIdBrand(1);
        //3.1
        List<Brand> brands1 = brandMapper.selectAllByStatusAndBrandNameAndCompanyName(status, companyName, brandName);
        //3.2
        List<Brand> brands2 = brandMapper.selectAllByStatusAndBrandNameAndBrandName2(getBrand);
        //3.3
        List<Brand> brands3 = brandMapper.selectAllByStatusAndBrandNameAndBrandName3(map);
        //4.
        List<Brand> brands4 = brandMapper.selectByConditionSingle(map);

        System.out.println("\n查询所有：" + brand);
        System.out.println("按ID查询：" + brands);
        System.out.println("多条件查询(多参数传入)：" + brands1);
        System.out.println("多条件查询(封装对象传入)：" + brands2);
        System.out.println("多条件查询(封装Map传入 + 动态查询)：" + brands3);
        System.out.println("动态单条件查询：" + brands4 + "\n");*/

        /*添加语句*/
/*        Brand add_brand = new Brand();
        add_brand.setBrandName("字节跳动有限公司");
        add_brand.setCompanyName("字节跳动");
        add_brand.setOrdered(130);
        add_brand.setDescription("激发创造，丰富生活");
        add_brand.setStatus(1);

        brandMapper.add(add_brand);
        //MyBatis:
           //openSession():默认开启事务，进行增删改操亻乍后需要使用sqISession.commit0;手动提交事务
           //openSession(true)：可以设置为自动提交事务（关闭事务）

        System.out.println("主键返回值：" + brandMapper.add1(add_brand));
        sqlSession.commit();*/

        /*修改语句*/
/*        Brand update_brand = new Brand();
        update_brand.setId(28);
        //update_brand.setOrdered(70);
        update_brand.setBrandName("安踏体育用品有限公司");
        //update_brand.setCompanyName("安踏");
        update_brand.setDescription("永不止步");
        update_brand.setStatus(1);

        //brandMapper.updateById(update_brand);
        brandMapper.updateId(update_brand);
        sqlSession.commit();*/

        /*删除语句*/
        //System.out.println("成功删除" + brandMapper.deleteById(29) + "条数据");

        int[] ids = {28, 33, 34, 35};
        System.out.println("成功删除" + brandMapper.deleteByIds(ids) + "条数据");
        sqlSession.commit();
        //4. 释放资源
        System.out.println("\n");

        sqlSession.close();
    }
}
