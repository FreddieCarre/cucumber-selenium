package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static void initProperties() {
        final String configPath = "src/test/resources/configs/testConfig.properties";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(configPath));
            Properties properties = System.getProperties();
            try {
                properties.load(reader);
                System.setProperties(properties);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("testConfig.properties not found at " + configPath);
        }
    }
}
