1. @SpringBootApplication注解：
    1.1. 当前类被 @SpringBootApplication 标注，被该注解标注的类是springboot项目的入口类。
    1.2. 该类的main方法就是整个springboot项目的入口。
    1.3. 关于 @SpringBootApplication 注解：
        从源码角度来看，该注解被以下三个注解标注了：
            @SpringBootConfiguration
            @EnableAutoConfiguration
            @ComponentScan
        也就是说 @SpringBootApplication 注解是一个复合注解，同时拥有以上三个注解的功能。
    1.4. 关于 @SpringBootConfiguration 注解：
        从源码角度来看，该注解被 @Configuration 注解标注。
            @SpringBootApplication
            public class SpringBoot02Application {
                @Bean
                public Date getDate(){
                    return new Date();
                }
                //从这里开始：
                //SpringApplication〖spring应用程序〗
                //run〖运行〗'run方法的第一个参数其实就是配置类,对应的就是以前的配置文件
                //springboot应用程序就是从这个配置类开始，加载所有的bean的
                //SpringBoot02Application.class又被称为源〖起源〗
                public static void main(String[] args) {
                    SpringApplication.run(SpringBoot02Application.class, args);
                }
            }
        因此得出一个结论：springboot项目的主入口类同时又是一个配置类。
        因此在springboot主入口配置类当中使用 @Bean 注解标注方法的话，该方法的返回值对象应该会被纳入IoC容器的管理。
    1.5. 关于 @EnableAutoConfiguration 注解：
        启用自动配置。
        也就是说默认情况下，springboot应用都会默认启用自动配置。
        自动配置有什么用？
            所谓的自动配置只要启动，springboot应用会去类路径当中查找class，根据类路径当中有某个类，或某些类，来自动管理bean，不需要我们程序员手动配置。
            比如：springboot检测到类路径当中有 SqlSessionFactory，或者在application.properties文件中配置了数据源，那么springboot会认为项目中
            有mybatis框架，因此会将mybatis中相关的bean自动初始化，然后放到IoC容器当中，自动将这些bean管理起来。
                sqlSessionFactory
                transactionManager
    1.6. 关于 @ComponentScan 注解：
        负责组件扫描的。代替的xml配置是：<context:component-scan base-packages="com.george.springboot" />
        这个注解出现在springboot主入口类上，因此组件扫描默认扫描的包是主入口程序所在的包以及该包下的所有子包。
        @SpringBootApplication
        public class Springboot304CoreAnnotationApplication {

            @Bean
            public Date getDate(){
                return new Date();
            }

            // 入口
            public static void main(String[] args) {
                // 从这里开始。
                // SpringApplication 【spring应用程序】
                // run 【运行】
                // run方法的第一个参数其实就是配置类，对应的就是以前的配置文件
                // springboot应用程序就是从这个配置类开始，加载所有的bean的。
                // Springboot304CoreAnnotationApplication.class 又被称为源【起源】
                //SpringApplication.run(Springboot304CoreAnnotationApplication.class, args);

                // 通过 run方法的返回值是可以获取到 Spring 上下文对象的。
                // ConfigurableApplicationContext 继承了 ApplicationContext
                // 因此 run方法的返回值就是spring容器。
                ConfigurableApplicationContext applicationContext = SpringApplication.run(Springboot304CoreAnnotationApplication.class, args);

                // 通过bean的name获取bean
                Object sqlSessionFactory = applicationContext.getBean("sqlSessionFactory");
                System.out.println(sqlSessionFactory);

                Object transactionManager = applicationContext.getBean("transactionManager");
                System.out.println(transactionManager);

                // 关闭容器
                applicationContext.close();
            }
        }

2. 在SpringBoot中如何做单元测试：
    使用@SpringBootTest注解：

    `@SpringBootTest` 会创建一个完整的 Spring 应用程序上下文（Application Context），这个上下文包含了应用程序的所有组件和服务。
        以下是 `@SpringBootTest` 做的一些主要工作：
        1.  创建 ApplicationContext ：
           - `@SpringBootTest` 使用 `SpringApplication` 的 `run()` 方法来启动一个 Spring Boot 应用程序上下文。这意味着它会加载应用程序的主配置类和其他相关的配置类。
        2.  加载配置文件 ：
           - 它会查找并加载默认的配置文件，如 `application.properties`
        3.  自动配置 ：
           - 如果应用程序依赖于 Spring Boot 的自动配置特性，`@SpringBootTest` 会确保这些自动配置生效。这意味着它会根据可用的类和bean来自动配置一些组件，如数据库连接、消息队列等。
        4.  注入依赖 ：
           - 使用 `@SpringBootTest` 创建的应用程序上下文允许你在测试类中使用 `@Autowired` 注入需要的 bean，就像在一个真实的 Spring Boot 应用程序中一样。
    总的来说，`@SpringBootTest` 为你的测试提供了尽可能接近实际运行时环境的条件，这对于验证应用程序的行为非常有用。

3. SpringBoot配置：
    3.1 Spring Boot 框架在启动时会尝试从以下位置加载 `application.properties` > `application.yml`配置文件：

        3.1.1. file:./config/：首先在Spring Boot 当前工作目录下的 `config` 文件夹中查找。(必须命名为/config)
            file:./config/application.properties
            file:./config/application.yml

        3.1.2. file:./：如果在当前工作目录下`config`目录中找不到时，再从当前工作目录中查找。
            file:./application.properties
            file:./application.yml

        3.1.3. classpath:/config/：如果从工作目录中找不到，会从类路径中找，先从类路径的 `/config/` 目录下寻找配置文件。
            classpath:./config/application.properties
            classpath:./config/application.yml

        3.1.4. classpath:/：如果在 `/config/` 下没有找到，它会在类路径的根目录下查找。
            classpath:./application.properties
            classpath:./application.yml

        3.1.5. 也可以通过命令指定配置文件路径 添加：--spring.config.location=
            java -jar sb3-01-first-web-1.0-SNAPSHOT.jar --spring.config.location=file:///E:\a\b\application.properties

    3.2 @Value注解：
            @Value注解可以将`application.properties`/`application.yml`文件中的配置信息注入/绑定到java对象的属性上。

    3.3 yaml配置文件：
            1. 数据结构：YAML支持多种数据类型，包括：
               1. 字符串、数字、布尔值
               2. 数组、list集合
               3. map键值对   等。
            2. YAML使用`一个空格`来分隔`属性名`和`属性值`，例如：
               1. `properties`文件中这样的配置：name=jack
               2. `yaml`文件中需要这样配置：name: jack
            3. YAML用`换行+空格`来表示层级关系。注意不能使用tab，必须是空格，空格数量无要求，大部分建议2个或4个空格。例如：
               1. `properties`文件中这样的配置：myapp.name=mall
               2. `yaml`文件中就需要这样配置：
                    myapp:
                      name: mall
            4. 同级元素左对齐。例如：
               1. `properties`文件中有这样的配置：
                    myapp.name=mall
                    myapp.count=10
               2. `yaml`文件中就应该这样配置：
                    myapp:
                      name: mall
                      count: 10
            5. 键必须是唯一的：在一个映射中，键必须是唯一的。
            6. 注释：使用`#`进行注释。
            7. 大小写敏感
            8. YAML的使用小细节
                第一：普通文本也可以使用单引号或双引号括起来：（当然普通文本也可以不使用单引号和双引号括起来。）
                    单引号括起来：单引号内所有的内容都被当做普通文本，不转义（例如字符串中有\n，则\n被当做普通的字符串）
                    双引号括起来：双引号中有 \n 则会被转义为换行符
                第二：保留文本格式
                    `|`     将文本写到这个符号的下层，会自动保留格式。
                第三：文档切割
                    `---` 这个符号下面的配置可以认为是一个独立的yaml文件。便于庞大文件的阅读。
    3.4 配置文件合并
        spring:
          config:
            import:
              - classpath:/config/application-mysql.yml
              - classpath:/config/application-redis.yml
    3.4 多环境切换
        spring:
          profiles:
            active: dev

    3.5 绑到到Bean

4. Spring Boot中如何进行AOP的开发
    4.1 导入依赖
        <!--aop启动器-->
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        当引入`aop启动器`之后，会引入`aop依赖`和`aspectj依赖`。
            aop依赖：如果只有这一个依赖，也可以实现AOP编程，这种方式表示使用了纯Spring AOP实现aop编程。
            aspectj依赖：一个独立的可以完成AOP编程的AOP框架，属于第三方的，不属于Spring框架。（我们通常用它，因为它的功能更加强大）
    4.2 如何编写切面
        @Component // 纳入IoC容器
        @Aspect // 指定该类为切面类
        public class xxxAspect {

            // 前置通知
            // 切入点表达式：service包下任意类的任意方法
            @Before("execution(* com.george.aop.service..*.*(..))")
            public void sysLog(JoinPoint joinPoint) throws Throwable {

                // 追加方法签名
                log.append(joinPoint.getSignature().getName());
                // 追加方法参数
                log.append("(");

                System.out.println(log);
            }
        }

5. SpringBoot 整合 Mybatis 框架
    5.1 导入依赖
            <!--mybatis的启动器-->
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>3.0.3</version>
            </dependency>
            <!--mysql的驱动依赖-->
            <dependency>
                <groupId>com.mysql</groupId>
                <artifactId>mysql-connector-j</artifactId>
                <scope>runtime</scope>
            </dependency>

    5.2 编写数据源配置
            # 数据库配置
            spring.datasource.url=jdbc:mysql://localhost:3306/springboot?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
            spring.datasource.username=root
            spring.datasource.password=@Poole0128
            spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

            # MyBatis配置
            # 告诉SpringBoot Mybatis的xml文件在哪里
            mybatis.mapper-locations=classpath:com/george/mapper/*.xml
            # 起别名
            mybatis.type-aliases-package=com.george.entity
            # 主要用于处理数据库字段名与Java对象属性名之间的命名差异
            mybatis.configuration.map-underscore-to-camel-case=true
    5.3 @Mapper 和 @MapperScan
            对于有大量 Mapper 类的项目 建议在入口程序上写 @MapperScan 避免编写重复大量 的@Mapper注解

6. Lombok 插件
    6.1 主要注解
        @Data：
            等价于 `@ToString`, `@EqualsAndHashCode`, `@Getter`，`@Setter`, `@RequiredArgsConstructor`.
            用于生成：必要参数的构造方法、getter、setter、toString、equals 和 hashcode 方法。
        @Getter / @Setter：
            分别用于生成所有的 getter 和 setter 方法。
            可以作用于整个类，也可以作用于特定的字段。
        @NoArgsConstructor：
            生成一个无参构造方法。
        @AllArgsConstructor：
            生成一个包含所有实例变量的构造器。
        @RequiredArgsConstructor ：
            生成包含所有被 `final` 修饰符修饰的实例变量的构造方法。
            如果没有的实例变量，则自动生成无参数构造方法
        @ToString / @EqualsAndHashCode ：
            用于生成 toString 和 equals/hashCode 方法。
            这两个注解都有属性，通过这个属性可以定制toString、hashCode、equals方法。

    6.2 @Builder
         GoF23种设计模式之一：建造模式
             建造模式（Builder Pattern）属于创建型设计模式。GoF23种设计模式之一。
             用于解决对象创建时参数过多的问题。它通过将对象的构造过程与其表示分离，使得构造过程可以逐步完成，而不是一次性提供所有参数。建造模式的主要目的是让对象的创建过程更加清晰、灵活和可控。
             简而言之，建造模式用于：
                 1. 简化构造过程：通过逐步构造对象，避免构造函数参数过多。
                 2. 提高可读性和可维护性：让构造过程更加清晰和有序。
                 3. 增强灵活性：允许按需配置对象的不同部分。
         这样可以更方便地创建复杂对象，并且使得代码更加易于理解和维护。

    6.3 @Singular
        @Singular注解是辅助@Builder注解的。
        当被建造的对象的属性是一个集合，
            这个集合属性使用@Singular注解进行标注的话，
            可以连续调用集合属性对应的方法完成多个元素的添加。
        如果没有这个注解，则无法连续调用方法完成多个元素的添加。代码如下：
            public class Person {
                // 属性
                private final String name;
                private final int age;
                private final String email;
                // Singular翻译为：单数。表示一条一条添加
                @Singular("addPhone")
                private final List<String> phones;
            }

7. SpringBoot的俩大核心：启动器 和 自动配置
        (** 配置类就是一个配置文件，一个配置文件中配置了大量的bean，一个bean就是一个组件，一个组件就是一个功能)
    7.1 基本原理：
        web启动器 ->(导入) 101个组件  <- 组件需要数据 <- XxxProperties(导入默认配置) <- application.yml(用户配置)
                            ↑                               ↑
            SpringBoot提供了大量的自动配置类：              web自动配置类
             XxxAutoConfiguration提供数据           这个属性类对象中一般都有默认值
    7.2 条件注解：做到组件按需加载
        + @ConditionalOnClass：当指定的类存在时，才创建Bean。
        + @ConditionalOnMissingClass：当指定的类不存在时，才创建Bean。
        + @ConditionalOnBean：当容器中存在指定的Bean时，才创建Bean。
        + @ConditionalOnMissingBean：当容器中不存在指定的Bean时，才创建Bean。
        + @ConditionalOnProperty：当配置文件中存在指定的属性时，才创建Bean。也可以设置属性值需要匹配的值。
        + @ConditionalOnResource：当指定的资源存在时，才创建Bean。
        + @ConditionalOnWebApplication：当应用程序是Web应用时，才创建Bean。
        + @ConditionalOnNotWebApplication：当应用程序不是Web应用时，才创建Bean
    7.3 核心流程：
        7.3.1   @SpringBootApplication  -→ 包含@EnableAutoConfiguration
                public class MyApplication {
                    public static void main(String[] args) {
                        SpringApplication.run(MyApplication.class, args);
                                                       ↑
                                                    源配置文件
                    }
                }

        7.3.2 @EnableAutoConfiguration
                将`AutoConfigurationImportSelector`作为一个Bean加载到IoC容器中。这个Bean的作用是：负责收集和选择所有符合条件的自动配置类。
                                        ↓
                @Import({AutoConfigurationImportSelector.class})
                public @interface EnableAutoConfiguration {
                    String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

                    Class<?>[] exclude() default {};

                    String[] excludeName() default {};
                }

                AutoConfigurationImportSelector核心代码：
                    // 1. 获取候选的自动配置类列表
                    // 通过注解元数据和属性信息，从META-INF/spring.factories等位置加载所有可能的自动配置类
                    List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes);
                    // 2. 移除候选配置类中的重复项
                    // 确保集合中每个配置类只出现一次，避免重复加载
                    configurations = this.<String>removeDuplicates(configurations);
                    // 3. 获取需要排除的配置类集合
                    // 根据@SpringBootApplication注解的exclude、excludeName等属性，解析需要排除的类
                    Set<String> exclusions = this.getExclusions(annotationMetadata, attributes);
                    // 4. 检查排除的类是否有效
                    // 验证排除的类是否存在于候选配置中，若不存在则可能抛出异常（如配置错误）
                    this.checkExcludedClasses(configurations, exclusions);
                    // 5. 从候选配置中移除所有需要排除的类
                    // 执行实际的排除操作，过滤掉不需要的配置类
                    configurations.removeAll(exclusions);
                    // 6. 通过配置类过滤器进一步筛选配置类
                    // 应用@Conditional等条件注解的过滤逻辑，最终确定需要加载的自动配置类
                    configurations = this.getConfigurationClassFilter().filter(configurations);

8. SpringBoot的web自动配置:
    8.1. web自动配置的依赖是如何传递的
            8.1.1 首先引入了`web启动器`，spring-boot-starter-web
            8.1.2 `web启动器`传递引入了`spring-boot-starter`
            8.1.3 `spring-boot-starter`会传递引入一个`spring-boot-autoconfigure`包
            8.1.4 在`spring-boot-autoconfigure`包中的`.imports`文件中罗列的需要导入的自动配置类
    8.2 web开发中 application.properties 中
            8.2.1 SpringMVC相关配置  spring.mvc.
            8.2.2 web开发通用配置     spring.web.
            8.2.3 文件上传配置        spring.servlet.multipart.
            8.2.4 服务器配置          server.
    8.3 关于`WebMvcConfigurer`接口
        这个接口不是SpringBoot框架提供的，是Spring MVC提供的，在Spring框架4.3版本中引入的。
        这个接口的作用主要是：允许开发者通过实现这个接口来定制Spring MVC的行为。
        在这个接口中提供了很多方法，需要改变Spring MVC的哪个行为，则重写对应的方法即可，下面是这个接口中所有的方法，以及每个方法对应的Spring MVC行为的解释：
        public interface WebMvcConfigurer {
            // 用于定制 Spring MVC 如何匹配请求路径到控制器
            default void configurePathMatch(PathMatchConfigurer configurer) {}

            // 用于定制 Spring MVC 的内容协商策略，以确定如何根据请求的内容类型来选择合适的处理方法或返回数据格式
            default void configureContentNegotiation(ContentNegotiationConfigurer configurer) {}

            // 用于定制 Spring MVC 处理异步请求的方式
            default void configureAsyncSupport(AsyncSupportConfigurer configurer) {}

            // 用于定制是否将某些静态资源请求转发WEB容器默认的Servlet处理
            default void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {}

            // 用于定制 Spring MVC 解析视图的方式，以确定如何将控制器返回的视图名称转换为实际的视图资源。
            default void configureViewResolvers(ViewResolverRegistry registry) {}

            // 用于定制 Spring MVC 如何处理 HTTP 请求和响应的数据格式，包括 JSON、XML 等内容类型的转换
            default void configureMessageConverters(List<HttpMessageConverter<?>> converters) {}

            // 用于定制 Spring MVC 如何处理控制器方法中发生的异常，并提供相应的错误处理逻辑。
            default void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {}

            // 用于定制 Spring MVC 如何处理数据的格式化和解析，例如日期、数值等类型的对象的输入和输出格式。
            default void addFormatters(FormatterRegistry registry) {}

            // 用于定制 Spring MVC 如何使用拦截器来处理请求和响应，包括在请求进入控制器之前和之后执行特定的操作。
            default void addInterceptors(InterceptorRegistry registry) {}

            // 用于定制 Spring MVC 如何处理静态资源（如 CSS、JavaScript、图片等文件）的请求。
            default void addResourceHandlers(ResourceHandlerRegistry registry) {}

            // 用于定制 Spring MVC 如何处理跨域请求，确保应用程序可以正确地响应来自不同域名的 AJAX 请求或其他跨域请求。
            default void addCorsMappings(CorsRegistry registry) {}

            // 用于快速定义简单的 URL 到视图的映射，而无需编写完整的控制器类和方法。
            default void addViewControllers(ViewControllerRegistry registry) {}

            // 用于定制 Spring MVC 如何解析控制器方法中的参数，包括如何从请求中获取并转换参数值。
            default void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {}

            // 用于定制 Spring MVC 如何处理控制器方法的返回值，包括如何将返回值转换为实际的 HTTP 响应。
            default void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {}


            // 用于定制 Spring MVC 如何处理 HTTP 请求和响应的数据格式，允许你添加或调整默认的消息转换器，以支持特定的数据格式。
            default void extendMessageConverters(List<HttpMessageConverter<?>> converters) {}

            // 用于定制 Spring MVC 如何处理控制器方法中抛出的异常，允许你添加额外的异常处理逻辑。
            default void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {}
        }

9. SpringBoot的web自动配置(静态自动配置):
    9.1 关于普通静态资源处理:
            SpringBoot对普通静态资源处理的规则是：
            当请求路径是[http://localhost:8080/**](http://localhost:8080/**)，根据控制器方法优先原则，会先去找合适的控制器方法，如果没有合适的控制器方法，静态资源处理才会生效，则自动去类路径下的以下4个位置查找：
            + classpath:/META-INF/resources/
            + classpath:/resources/
            + classpath:/static/
            + classpath:/public/

使用快捷键:↑ ← → ↑
    * HOME 键 : 快速定位一行文字开头
    * END 键 : 快速定位一行文字末尾
    * shift + home 键 : 快速选中光标到一行开头
    * shift + end 键 : 快速选中光标到一行末尾
    * ctrl + w 键 : 快速选中一行文本
    * ctrl + d 键 : 复制一行
    * ctrl + f 键 : 搜索
    * ctrl + b 键 : 转向方法声明
    * ctrl + j 键 : 显示上下文定义模板
    * ctrl + e 键 : 打开最近打开的文件列表(ctrl + shift + e)
    * ctrl + r 键 : 打开替换搜索
    * ctrl + o 键 ：
    * ctrl + f4 键 : 关闭当前文件
    * ctrl + f12 键 ：在当前Java文件搜索
    * ctrl + shift + f4 : 关闭所有文件



































