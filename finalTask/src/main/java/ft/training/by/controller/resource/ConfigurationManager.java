package ft.training.by.controller.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = new FileInputStream(
                "/Users/ivansilaev/Desktop/javaTraining/finalTask/src/main/resources/config.properties")) {
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
