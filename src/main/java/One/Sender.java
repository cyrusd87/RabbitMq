package One;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {

    private static ConnectionFactory connectionFactory;
    private static String queueName;

    public Sender(String host, String queueName) {
        this.queueName = queueName;
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
    }

    public void Send(String message) throws IOException, TimeoutException {

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(queueName, false, false, false, null);

        channel.basicPublish("", queueName, null, message.getBytes());

        System.out.println("[x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}