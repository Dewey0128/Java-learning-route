/*import com.george.autowired.controller.UserController;*/
import com.george.config.SpringConfig;
import com.george.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAnnotationTest {
    @Test
    public void testAutowired(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController userController = context.getBean(UserController.class);

        userController.userControllerAdd();
    }

    @Test
    //全注解开发
    public void testAllAnnotation(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean("userController", UserController.class);

        userController.userControllerAdd();
    }
}
