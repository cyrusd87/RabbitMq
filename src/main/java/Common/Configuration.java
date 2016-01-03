package Common;

public class Configuration {

    private String host;
    private String queueName;

    public Configuration(String host,String queueName) {

        this.host = host;
        this.queueName = queueName;
    }

    public String getHost() {
        return host;
    }

    public String getQueueName() {
        return queueName;
    }
}
