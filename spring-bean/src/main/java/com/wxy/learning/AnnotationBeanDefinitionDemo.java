package com.wxy.learning;

import com.wxy.learning.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/3/2020 10:51
 * @Version: 1.0
 **/
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        //创建beanfactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册Configuration.class
        applicationContext.register(Config.class);

        registryUserBeanDefinition(applicationContext);

        //启动spring应用上下文
        applicationContext.refresh();

        //按照类型进行依赖查找
        System.out.printf("Config all beans %s \n", applicationContext.getBeansOfType(Config.class));
        System.out.printf("User %s", applicationContext.getBeansOfType(User.class));

        //显示关闭spring 应用上下文
        applicationContext.close();
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1).addPropertyValue("name", "wxy");

        //注册BeanDefinition
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }

    public static void registryUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry, null);
    }

    public static class Config {
        @Bean(name = {"user", "xiaoming"})
        public User user() {
            User user = new User();
            user.setId(1);
            user.setName("wxy");
            return user;
        }
    }
}
