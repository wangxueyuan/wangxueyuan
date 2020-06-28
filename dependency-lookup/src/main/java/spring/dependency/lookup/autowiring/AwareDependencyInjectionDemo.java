package spring.dependency.lookup.autowiring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareDependencyInjectionDemo implements BeanFactoryAware {
    private static BeanFactory beanFactory;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        applicationContext.register(AwareDependencyInjectionDemo.class);

        applicationContext.refresh();

        System.out.println(beanFactory == applicationContext.getBeanFactory());
        applicationContext.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareDependencyInjectionDemo.beanFactory = beanFactory;
    }
}
