import com.george.static_proxy.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void staticProxyTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        OrderController orderController = context.getBean(OrderController.class);

        orderController.generate();
        orderController.detail();
        orderController.modify();
    }
}
