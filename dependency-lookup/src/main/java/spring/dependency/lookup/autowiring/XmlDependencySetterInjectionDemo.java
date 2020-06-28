package spring.dependency.lookup.autowiring;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import spring.dependency.bean.UserHolder;

public class XmlDependencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String xmlPath = "classpath:/META-INF/dependency-injection-setter.xml";
        //加载xml资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(xmlPath);
        //依赖查找并且创建bean
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
