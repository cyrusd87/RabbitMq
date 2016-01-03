package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {

    public Configuration Load() throws IOException {

        String rabbithost = "";
        String rabbitqueue = "";
        InputStream inputStream = null;

        try {
            Properties prop = new Properties();
            inputStream =  getClass().getClassLoader().getResourceAsStream("config.conf");

            prop.load(inputStream);
            // get the property value and print it out
            rabbithost = prop.getProperty("rabbithost");
            rabbitqueue = prop.getProperty("rabbitqueue");

            System.out.println(rabbithost);
            System.out.println(rabbitqueue);
        } finally {
            inputStream.close();
            return new Configuration(rabbithost, rabbitqueue);
        }

    }

}

