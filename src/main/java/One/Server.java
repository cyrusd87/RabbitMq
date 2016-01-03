package One;

import Common.Configuration;
import Common.ConfigurationLoader;

import java.util.concurrent.TimeoutException;

public class Server {

    public static void main(String[] argv)
            throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {
        Configuration configuration= new ConfigurationLoader().Load();
        Receiver receiver = new Receiver(configuration.getHost(), configuration.getQueueName());
        receiver.Receive();
    }


}
