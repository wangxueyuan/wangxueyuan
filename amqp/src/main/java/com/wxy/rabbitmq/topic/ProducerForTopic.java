package com.wxy.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 9/14/2020 21:39
 * @Version: 1.0
 **/
public class ProducerForTopic {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        String exchange = "test_topic_exchange";
        String[] routingKeys = {"test.direct", "test.update", "test.wagnx.update", "test."};
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            for (String routingKey : routingKeys) {
                String msg = "Hello rabbitMQ" + routingKey;
                channel.basicPublish(exchange, routingKey, null, msg.getBytes());
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
