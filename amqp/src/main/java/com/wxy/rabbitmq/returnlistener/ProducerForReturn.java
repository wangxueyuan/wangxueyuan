package com.wxy.rabbitmq.returnlistener;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ReturnListener;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 9/18/2020 17:06
 * @Version: 1.0
 **/
public class ProducerForReturn {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("/");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "test_return_exchange";
        String routingKey = "return.save";
        String routingKeyError = "abc.save";


        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey,
                                     AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("-----------consume message----------");
                System.out.println("consumerTag: " + replyCode);
                System.out.println("replyText: " + replyText);
                System.out.println("properties: " + properties);
                System.out.println("body: " + new String(body));
            }
        });

        String msg = "Hello rabbitMq send return message";
        channel.basicPublish(exchangeName, routingKey, true, null, msg.getBytes());

        String msg2 = "Hello rabbitMq send return error message";
        channel.basicPublish(exchangeName, routingKeyError, true, null, msg2.getBytes());
    }
}
