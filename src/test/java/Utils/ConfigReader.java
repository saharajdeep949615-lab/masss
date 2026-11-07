package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    public static String getProperty(String key) {
        if (properties==null) {
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                properties = new Properties();
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
}