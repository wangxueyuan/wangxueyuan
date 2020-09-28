package com.wxy.learning;

import com.wxy.learning.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/3/2020 10:33
 * @Version: 1.0
 **/
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        //1、通过BeanDefinitionBuilder进行构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //属性设置
        beanDefinitionBuilder.addPropertyValue("id", 1);
        beanDefinitionBuilder.addPropertyValue("name", "wxy");
        //achieve bean instance
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        //2、通过abstractBeanDefinition构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 1).add("name", "wxy");
        genericBeanDefinition.setPropertyValues(propertyValues);

        System.out.println(genericBeanDefinition.getAttribute("id"));
        System.out.println(genericBeanDefinition.getBeanClass());
    }
}
