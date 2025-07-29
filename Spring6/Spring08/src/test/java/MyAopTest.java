import com.george.config.Spring6Config;
import com.george.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAopTest {
    @Test
    public void aopTest(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("bean.xml");

        OrderService service = context.getBean(OrderService.class);
        //service.generate();
        service.detail();
        //service.modify();
    }

    @Test
    public void aopNoXmlTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);

        OrderService service = applicationContext.getBean(OrderService.class);
        service.detail();
    }
}
