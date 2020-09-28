package com.wxy.rabbitmq.tutorial;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 9/15/2020 11:17
 * @Version: 1.0
 **/
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactor = new ConnectionFactory();
        connectionFactor.setHost("localhost");
        connectionFactor.setPort(5672);
        connectionFactor.setVirtualHost("/");

        Connection connection = connectionFactor.newConnection();

    }
}
