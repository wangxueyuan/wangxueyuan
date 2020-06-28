package org.geekbang.thinking.spring.ioc.overview.lookup;

import org.geekbang.thinking.spring.ioc.overview.domain.Super;
import org.geekbang.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 5/18/2020 20:51
 * @Version: 1.0
 **/
public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanMemberFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup" +
                "-demo.xml");
        //实时查找
        lookupInRealTime(beanMemberFactory);
        //延迟查找
        looupInLazy(beanMemberFactory);
        //通过注解查找
        lookupByAnnotation(beanMemberFactory);
        //通过类名查找
        lookupByType(beanMemberFactory);
        //查找几何
        lookupCollectionByType(beanMemberFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanMemberFactory) {
        if (beanMemberFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanMemberFactory;
            Map<String, User> userMap = (Map) listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap);
        }
    }

    private static void lookupInRealTime(BeanFactory factory) {
        User user = (User) factory.getBean("user");
        System.out.println("realtime"+user.toString());
    }

    private static void looupInLazy(BeanFactory factory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) factory.getBean("objectFactoryBean");
        User user = objectFactory.getObject();
        System.out.println("lazy init"+user.toString());
    }

    private static void lookupByType(BeanFactory factory) {
        User user = factory.getBean(User.class);
        System.out.println("realtime"+user.toString());
    }

    private static void lookupByAnnotation(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) factory;
            Map<String, User> userMap = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(userMap);
        }
    }
}
