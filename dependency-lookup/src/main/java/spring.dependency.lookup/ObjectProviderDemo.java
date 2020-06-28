package spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ObjectProviderDemo {
    public static void main(String[] args) {
        //create beanfactory container
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //register current class as configuration class
        applicationContext.register(ObjectProviderDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查找集合对象
        lookupByObjectProvider(applicationContext);
        applicationContext.close();
    }

    @Bean
    public String helloWorld() {
        return "Hello,World";
    }
    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }
}
