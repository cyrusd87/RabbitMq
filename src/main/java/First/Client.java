package First;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Client {

    public static void main(String[] argv) throws IOException, TimeoutException {
        Sender.SetHost("localhost");
        Sender.SetQueueName("hello");
        Sender.Send("Hello World!");
    }
}
