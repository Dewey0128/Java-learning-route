import com.alibaba.druid.pool.DruidDataSource;
import com.george.dao.PersonDao;
import com.george.pojo.Book;
import com.george.pojo.User;
import com.george.pojo.collections.Student;
import com.george.pojo.objectBean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyIoCTest {
    @Test
    //根据Id获取Bean
    public void getBeanById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        User user = (User) context.getBean("user");
        System.out.println("根据Id获取Bean:  " + user);
    }

    @Test
    //根据Class类型获取Bean
    public void getBeanByClass(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        User user =context.getBean(User.class);
        System.out.println("根据Class类型获取Bean:  " + user);
    }

    @Test
    //根据Id和Class类型获取Bean
    public void getBeanByIdAndClass(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        User user =context.getBean("user", User.class);
        System.out.println("根据Id和Class类型获取Bean:  " + user);
    }

    @Test
    // 根据抽象类，获取一个实现类的Bean:组件类实现了接口，根据接口类型可以获取 bean
    public void getBeanByAbstract(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        PersonDao personDao = context.getBean(PersonDao.class);
        System.out.println(personDao);  //com.george.pojo.StudentPersonDaoImpl@18bc345
    }

    @Test
    // 依赖注入 ： setter注入
    public void DiBySetter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 当一个类被多次转为Bean,则使用 .class 方法就会报错
        Book book = context.getBean(Book.class);
        System.out.println(book);
    }

    @Test
    // 依赖注入 ： 有参构造器注入
    public void DiByParamsCon(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Book book = context.getBean("bookCon", Book.class);
        System.out.println(book);
    }

    @Test
    // 依赖注入 ： 含有外部对象依赖注入
    // 引用外部Bean
    public void DiByOutObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Employee emp = context.getBean("emp", Employee.class);
        emp.work();
    }

    @Test
    // 依赖注入 ： 内部bean
    public void DiByInObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Employee empInner = context.getBean("empInner", Employee.class);
        empInner.work();
    }

    @Test
    //依赖注入 ： 内部含集合（List, Map）
    public void DiByCollections(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Student student = context.getBean("std", Student.class);
        student.study();

    }

    @Test
    //依赖注入 ： 内部含集合（List, Map） p命名空间注入
    public void DiByCollectionsP(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Student student = context.getBean("stdp", Student.class);
        student.study();
    }

    @Test
    //引入外部属性文件 数据库连接测试
    public void testDataSource() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource dataSource = (DruidDataSource) context.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource.getUrl());
    }
}
