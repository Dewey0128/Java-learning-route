import com.george.dynamic_proxy.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void dynamicProxyTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        OrderController orderController = context.getBean(OrderController.class);

        orderController.generate();
        orderController.detail();
        orderController.modify();
    }
}
