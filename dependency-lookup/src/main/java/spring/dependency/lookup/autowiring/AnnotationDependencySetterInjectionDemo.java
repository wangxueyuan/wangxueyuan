package spring.dependency.lookup.autowiring;

import org.geekbang.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.dependency.bean.UserHolder;

public class AnnotationDependencySetterInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencySetterInjectionDemo.class);
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath = "classpath:/META-INF/dependency-lookup-demo.xml";
        //加载xml资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(xmlPath);


        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}
