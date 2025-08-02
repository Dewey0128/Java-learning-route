import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectTest {
    @Test
    // 获取 Class 并 实例化
    public void getClazz() throws Exception {
        // 1. 类名.class
        Class<Car> carClass01 = Car.class;
        System.out.println(carClass01);

        // 2. 对象.getClass()
        Class<? extends Car> carClass02 = new Car().getClass();
        System.out.println(carClass02);

        // 3. Class.forName("全路径")
        Class<?> carClass03 = Class.forName("Car");
        System.out.println(carClass03);

        // 实例化
        Car car = carClass01.getConstructor().newInstance();
        System.out.println(car);
    }

    @Test
    public void getConstructors_() throws Exception{
        Class<Car> carClass = Car.class;

        // 获取构造方法
        /*
            getConstructors() 获取所有public的构造方法
            getDeclaredConstructors() 获取所有构造方法 public private

        * */
        Constructor<Car> constructor = carClass.getConstructor();
        System.out.println("方法名称：" + constructor.getName() +
                           "\n参数个数：" + constructor.getParameterCount() +
                           "\n参数类型：" + Arrays.toString(constructor.getParameterTypes()));

        System.out.println("---------------------------");
        Constructor<?>[] declaredConstructors = carClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("方法名称：" + declaredConstructor.getName() +
                    "\n参数个数：" + declaredConstructor.getParameterCount() +
                    "\n参数类型：" + Arrays.toString(declaredConstructor.getParameterTypes()));
        }
    }

    @Test
    public void constructorCreatObject() throws Exception {
        Class<Car> carClass = Car.class;

        // 指定有参构造创建对象
        // 1. 构造public
        Constructor<Car> constructor = carClass.getConstructor(String.class,
                                                                int.class,
                                                                String.class);


        Car car = constructor.newInstance("夏利", 10, "黑色");
        System.out.println(car);

        // 2. 构造private  可以强行创造对象
        Constructor<Car> declaredConstructor = carClass.getDeclaredConstructor(String.class, int.class);
        // 设置权限
        declaredConstructor.setAccessible(true);

        Car car1 = declaredConstructor.newInstance("凯迪拉克", 10);
        System.out.println(car1);
    }

    @Test
    public void getType() throws Exception{
        Class<Car> carClass = Car.class;

        //获取所有 public 属性
        Field[] fields = carClass.getFields();
        System.out.println("获取所有 public 属性:");
        for (Field field : fields) {
            System.out.println(field.getName() + field.getType());
        }

        // 获取所有属性 public private
        Field[] declaredFields = carClass.getDeclaredFields();
        System.out.println("\n获取所有 public private 属性:");
        Car car = carClass.getDeclaredConstructor().newInstance();
        for (Field declaredField : declaredFields) {
            System.out.println("属性名:" + declaredField.getName() +
                               " 属性类型:" + declaredField.getType());
            if(declaredField.getName().equals("name")){
                // 设置允许访问
                declaredField.setAccessible(true);
                declaredField.set(car, "五菱宏光");
                System.out.println(car);
            }
        }
    }

    @Test
    public void getMethod_() throws Exception {
        Class<Car> carClass = Car.class;
        Car car = carClass.getConstructor(String.class, int.class, String.class)
                          .newInstance("夏利", 10, "黑色");


        // 1.public方法
        Method[] methods = carClass.getMethods();
        for (Method method : methods) {
            System.out.println("方法名" + method.getName());

            // 执行某个方法
            if(method.getName().equals("toString")){
                Object invoke = method.invoke(car);
                System.out.println(method.getName() + " 执行了:" + invoke);
            }
        }

        // 2.private方法
        Method[] declaredMethods = carClass.getDeclaredMethods();
        System.out.println("/n---------------------/n所有方法：");
        for (Method declaredMethod : declaredMethods) {
            // 执行某个方法
            if(declaredMethod.getName().equals("run")){
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(car);
            }
        }
    }

}
