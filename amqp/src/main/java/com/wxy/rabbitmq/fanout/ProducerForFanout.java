package com.wxy.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 9/13/2020 15:40
 * @Version: 1.0
 **/
public class ProducerForFanout {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        String exchange = "test_fanout_exchange";
        String routingKey = "test.direct111";
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            for (int i = 0; i < 5; i++) {
                String msg = "Hello rabbitMq " + i;
                channel.basicPublish(exchange, routingKey, null, msg.getBytes());
                System.out.println(msg + " has sent out!");
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
