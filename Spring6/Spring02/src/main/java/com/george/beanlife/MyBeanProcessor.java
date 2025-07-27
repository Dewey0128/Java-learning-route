package com.george.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/*bean的后置处理器:
    bean的后置处理器会在生命周期的初始化前后添加额外的操作，
    * 需要实现BeanPostProcessor接口，且配置到IOC容器中，
    * 需要注意的是:
    * bean后置处理器不是单独针对某一个bean生效，而是针对IOC容器中所有bean都会执行
    创建bean的后置处理器：
* */
public class MyBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3. " + beanName + " = " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5. " + beanName + " = " + bean);
        return bean;
    }
}
