package com.wxy.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wxy.rabbitmq.RabbitMqConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 9/13/2020 15:40
 * @Version: 1.0
 **/
public class ConsumerForFanout {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        String exchange = "test_fanout_exchange";
        String routingKey = "test.direct";
        String queueName = "test_fanout_queue11";
        String exchangeType = "fanout";
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(exchange, exchangeType, true, true, null);
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, exchange, routingKey);
//        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//
//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            String message = new String(delivery.getBody(), "UTF-8");
//            System.out.println(" [x] Received '" + message + "'");
//        };
//        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
//        });
        channel.basicConsume(queueName, new RabbitMqConsumer(channel));

    }
}
