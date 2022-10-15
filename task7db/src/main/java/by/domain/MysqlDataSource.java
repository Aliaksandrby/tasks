package by.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static by.domain.ConfigData.PROPERTIES_FILE_NAME;

public class MysqlDataSource {

    private final String propertyFile;

    public MysqlDataSource() {
        this(PROPERTIES_FILE_NAME);
    }

    public MysqlDataSource(String propertyFile) {
        this.propertyFile = propertyFile;
        try {
            Class.forName(ConfigData.getProperties(propertyFile).getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        Properties jdbcProperties = ConfigData.getProperties(propertyFile);
        try {
            connection = DriverManager.getConnection(
                    jdbcProperties.getProperty("url"),
                    jdbcProperties.getProperty("username"),
                    jdbcProperties.getProperty("password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
