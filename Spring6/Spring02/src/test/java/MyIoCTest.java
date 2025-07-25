import com.george.dao.PersonDao;
import com.george.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        User user = (User) context.getBean(User.class);
        System.out.println("根据Class类型获取Bean:  " + user);
    }

    @Test
    //根据Id和Class类型获取Bean
    public void getBeanByIdAndClass(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        User user = (User) context.getBean("user", User.class);
        System.out.println("根据Id和Class类型获取Bean:  " + user);
    }

    @Test
    // 根据抽象类，获取一个实现类的Bean:组件类实现了接口，根据接口类型可以获取 bean
    public void getBeanByAbstract(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        PersonDao personDao = context.getBean(PersonDao.class);
        System.out.println(personDao);  //com.george.pojo.StudentPersonDaoImpl@18bc345
    }
}
