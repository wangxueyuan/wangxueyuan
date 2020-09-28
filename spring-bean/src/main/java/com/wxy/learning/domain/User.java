package com.wxy.learning.domain;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 5/18/2020 20:53
 * @Version: 1.0
 **/
public class User {
    private String name;
    private int id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
