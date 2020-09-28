package com.wxy.learning.domain;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 5/18/2020 21:12
 * @Version: 1.0
 **/
@Super
public class SuperUser extends User {
    private String address;

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
