
import com.george.spring6.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringTest {

    @Test
    public void testUserObj() {
        //加载spring配置文件，对象创建
         /*不用new方式，那么容器是怎么创建对象的？
            利用 反射
             1. 加载bean.xml配置文件
             2. 对xml文件进行解析操作
             3. 获取xml文件bean标签属性值：id值 和 class值
             4. 使用反射根据类全路径创建对象
         */
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        //获取创建的对象
        /*创建的对象放到哪里？
            放到一个Map里
            Map<String, BeanDefinition> beanDefinitionMap;
                key : 唯一标识
                value  : 类的定义（描述信息）
        * */
        User user = (User) context.getBean("user");
        System.out.println(user);

        //使用方法调用方法测试
        user.add();
    }

    @Test
    public void testUserClass() throws Exception {
        // 4.1 获取类Class对象
        Class<?> userClass = Class.forName("com.george.spring6.User");
        // 4.2 调用方法创建对象
        User user = (User) userClass.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
