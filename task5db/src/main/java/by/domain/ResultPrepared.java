package by.domain;

import java.sql.*;

public class ResultPrepared {
    public void show() {
        try (Connection connection = new MysqlConnector().getConnection()){
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT payment_id, paydate, receivers.receiver, expense FROM" +
                    " expenses INNER JOIN receivers ON expenses.receiver_id= receivers.receiver_id ORDER BY expenses.payment_id");
            ResultSet resultSet = preparedStatement.executeQuery();

            Output.setResult(resultSet);

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
