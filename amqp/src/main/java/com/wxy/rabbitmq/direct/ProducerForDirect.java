package com.wxy.rabbitmq.direct;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 9/13/2020 15:40
 * @Version: 1.0
 **/
public class ProducerForDirect {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        String exchange = "test_direct_exchange";
        String routingKey = "test.direct";
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            for (int i = 0; i < 5; i++) {
                String msg = "Hello rabbitMq " + i;
                Map<String, Object> headers = new HashMap<>();
                headers.put("my1", "111");
                headers.put("my2", "222");
                AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().deliveryMode(2)
                        .contentEncoding("UTF-8").expiration("1000").headers(headers).build();
                channel.basicPublish(exchange, routingKey, properties, msg.getBytes());
                System.out.println(msg + " has sent out!");
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
