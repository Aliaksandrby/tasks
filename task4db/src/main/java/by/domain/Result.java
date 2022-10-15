package by.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Result {
    public void show() {
        try (Connection connection = new MysqlConnector().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT payment_id, paydate, receivers.receiver, expense FROM" +
                    " expenses INNER JOIN receivers ON expenses.receiver_id= receivers.receiver_id ORDER BY expenses.payment_id");

            Output.setResult(resultSet);

        } catch(SQLException e){
                e.printStackTrace();
        }
    }
}