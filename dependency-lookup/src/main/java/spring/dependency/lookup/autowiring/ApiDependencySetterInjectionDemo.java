package spring.dependency.lookup.autowiring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.dependency.bean.UserHolder;

public class ApiDependencySetterInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        applicationContext.registerBeanDefinition("userHolder",userHolderBeanDefinition);
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath = "classpath:/META-INF/dependency-lookup-demo.xml";
        //加载xml资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(xmlPath);


        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }

    /**
     *
     * @return
     */
   private static BeanDefinition createUserHolderBeanDefinition() {
       BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
       definitionBuilder.addPropertyReference("user", "superUser");
       return definitionBuilder.getBeanDefinition();
   }
}
