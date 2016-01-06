package WorkQueues;


import Common.Configuration;
import Common.ConfigurationLoader;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Client {

    public static void main(String[] argv) throws IOException, TimeoutException {
        Configuration configuration= new ConfigurationLoader().Load();
        NewTask sender = new NewTask(configuration.getHost(), configuration.getQueueName());

        for (int index = 0; index < 1000; index++) {
            sender.Send("Hello World number:' " + index + "'");
        }
    }


}
