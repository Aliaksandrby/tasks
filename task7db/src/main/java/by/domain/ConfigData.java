package by.domain;

import java.io.IOException;
import java.util.Properties;

public class ConfigData {
    public static final String PROPERTIES_FILE_NAME = "file.properties";

    private static Properties properties;

    public static Properties getProperties(String propertyFile) {
        if(properties == null) {
            properties = new Properties();
            try {
                properties.load(MysqlDataSource.class.getClassLoader().getResourceAsStream(propertyFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
