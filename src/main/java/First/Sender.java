package First;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender { 

    private static ConnectionFactory connectionFactory;
    private static String queueName;

    public Sender() {
        connectionFactory = new ConnectionFactory();
    }

    public static void SetHost(String host) {
        connectionFactory.setHost(host);
    }

    public static void SetQueueName(String queueName) {

        queueName = queueName;
    }

    public static void Send(String message) throws IOException, TimeoutException {

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(queueName, false, false, false, null);

        channel.basicPublish("", queueName, null, message.getBytes());

        System.out.println("[x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}