package com.george.config;

// WebConfig.java - Web配置类 (整合Thymeleaf)
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.george")
public class WebConfig implements WebMvcConfigurer {

    // 配置视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 将根路径 "/" 映射到 "index" 视图
        registry.addViewController("/").setViewName("user_index");

        /*// 其他简单页面映射
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/contact").setViewName("contact");*/
    }

    // 配置Thymeleaf模板解析器
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");  // 模板文件位置
        templateResolver.setSuffix(".html");            // 模板文件后缀
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);  // 开发时设置为false，生产环境设为true
        return templateResolver;
    }

    // 配置Thymeleaf模板引擎
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true); // 启用Spring表达式语言
        return templateEngine;
    }

    // 配置Thymeleaf视图解析器
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setContentType("text/html; charset=UTF-8");
        return viewResolver;
    }

    // 配置静态资源处理
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }

    // 注册HiddenHttpMethodFilter过滤器
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilterRegistration() {
        FilterRegistrationBean<HiddenHttpMethodFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new HiddenHttpMethodFilter());
        registration.addUrlPatterns("/*"); // 拦截所有请求
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE); // 新增：设置最高优先级
        return registration;
    }

}