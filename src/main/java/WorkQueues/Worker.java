package WorkQueues;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Worker {

    private ConnectionFactory connectionFactory;
    private String queueName;

    public Worker(String host, String queueName) {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        this.queueName = queueName;
    }

    public void Receive() throws IOException, TimeoutException {
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queueName, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                //System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(" [x] Received '" + message + "done!'");
                }
            }
        };

        while(true) {
            channel.basicConsume(queueName, true, consumer);
        }
    }

    private void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            if (ch == 2) Thread.sleep(1000);
            if (ch == 5) Thread.sleep(2000);
        }
    }
}