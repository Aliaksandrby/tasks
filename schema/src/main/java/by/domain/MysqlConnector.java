package by.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {
    private final String user = "root";
    private final String password = "root";
    private final String nameDB = "mysqldb";
    public MysqlConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameDB + "?serverTimezone=UTC",
                    user,
                    password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
