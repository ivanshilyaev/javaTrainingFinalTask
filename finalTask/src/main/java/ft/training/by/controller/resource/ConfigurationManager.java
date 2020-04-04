package ft.training.by.controller.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     ConfigurationManager.class.getClassLoader().getResourceAsStream(
                             "config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.error("Could't load config properties", e);
        }
    }

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
