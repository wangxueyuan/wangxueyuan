package spring.dependency.lookup.autowiring;

import org.geekbang.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.dependency.bean.UserHolder;

public class FieldAutowiredDemo {
    @Autowired
    private UserHolder userHolder;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration class -》spring bean
        applicationContext.register(FieldAutowiredDemo.class);
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath = "classpath:/META-INF/dependency-lookup-demo.xml";
        //加载xml资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(xmlPath);

        applicationContext.refresh();

        FieldAutowiredDemo demo = applicationContext.getBean(FieldAutowiredDemo.class);
        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);

        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder() {
        User user = new User();
        user.setId(1);
        user.setName("tracy2");
        return new UserHolder(user);
    }
}
