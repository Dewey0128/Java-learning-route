package com.george.config;// AppConfig.java - 主配置类
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = {
        "com.george"
})
@MapperScan(basePackages = "com.george.mapper")
@EnableTransactionManagement
public class AppConfig {

    // 配置Druid数据源
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springmvc?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("@Poole0128");

        // Druid连接池优化配置
        dataSource.setInitialSize(5);          // 初始连接数
        dataSource.setMinIdle(5);              // 最小空闲连接数
        dataSource.setMaxActive(20);           // 最大连接数
        dataSource.setMaxWait(60000);          // 获取连接最大等待时间(毫秒)
        dataSource.setTimeBetweenEvictionRunsMillis(60000); // 间隔多久检测一次空闲连接
        dataSource.setMinEvictableIdleTimeMillis(300000);    // 连接最小生存时间
        dataSource.setValidationQuery("SELECT 1");          // 测试连接有效性的SQL
        dataSource.setTestWhileIdle(true);     // 空闲时检测连接有效性
        dataSource.setTestOnBorrow(false);     // 借用连接时不检测
        dataSource.setTestOnReturn(false);     // 归还连接时不检测

        // 使用 SLF4J 替代 log4j
        try {
            dataSource.setFilters("stat,wall,slf4j"); // 关键修改
        } catch (SQLException e) {
            throw new RuntimeException("Failed to set Druid filters", e);
        }

        return dataSource;
    }

    // 配置SqlSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        // MyBatis配置
        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true); // 开启驼峰命名
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class); // 日志输出

        sessionFactory.setConfiguration(configuration);

        // 配置类型别名包
        sessionFactory.setTypeAliasesPackage("com.george.pojo");

        return sessionFactory;
    }

    // 配置事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}