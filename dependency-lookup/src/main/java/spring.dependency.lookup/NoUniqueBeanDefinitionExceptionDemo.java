package spring.dependency.lookup;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 TypeSafetyDependencyLookupDemo 作为配置类（Configuration Class）
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
        // 启动应用上下文
        applicationContext.refresh();

        try {
            applicationContext.getBean(String.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.printf("出现重复bean定义，重复个数%d,错误内容%s", e.getNumberOfBeansFound(), e.getMessage());
        }
        applicationContext.close();
    }

    @Bean
    public String bean1() {
        return "1";
    }

    @Bean
    public String bean2() {
        return "2";
    }
}
