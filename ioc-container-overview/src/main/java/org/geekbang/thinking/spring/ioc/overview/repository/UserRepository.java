package org.geekbang.thinking.spring.ioc.overview.repository;

import org.geekbang.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;

import java.util.Collection;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 5/27/2020 11:52
 * @Version: 1.0
 **/
public class UserRepository {
    private Collection<User> users;//自定义bean
    private BeanFactory beanFactory;//内建非bean对象

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
