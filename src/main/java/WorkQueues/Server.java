package WorkQueues;

import Common.Configuration;
import Common.ConfigurationLoader;

import java.util.concurrent.TimeoutException;

public class Server {

    public static void main(String[] argv)
            throws java.io.IOException,
            InterruptedException, TimeoutException {
        Configuration configuration= new ConfigurationLoader().Load();
        Worker receiver = new Worker(configuration.getHost(), configuration.getQueueName());
        receiver.Receive();
    }


}
