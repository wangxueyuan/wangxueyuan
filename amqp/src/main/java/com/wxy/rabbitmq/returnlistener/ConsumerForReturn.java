package com.wxy.rabbitmq.returnlistener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wxy.rabbitmq.RabbitMqConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 9/18/2020 18:13
 * @Version: 1.0
 **/
public class ConsumerForReturn {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("/");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "test_return_exchange";
        String routingKey = "return.#";
        String queueName = "test_return_queue";

        channel.exchangeDeclare(exchangeName, "topic", true);
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);

        channel.basicConsume(queueName, new RabbitMqConsumer(channel));

    }
}
