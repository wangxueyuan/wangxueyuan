package spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HierarchyDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchyDependencyLookupDemo.class);
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("current parent bean factory is:{}"+beanFactory.getParentBeanFactory());

        beanFactory.setParentBeanFactory(createParentBeanFactory());
        System.out.println("current parent bean factory is:{}"+beanFactory.getParentBeanFactory());

        applicationContext.refresh();
        applicationContext.close();

    }

    private static BeanFactory createParentBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-demo.xml";
        reader.loadBeanDefinitions(location);
        return beanFactory;
    }
}
