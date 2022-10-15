package by.domain;

import java.sql.*;

public class TableWritablePrepared {
    private final String [] args;
    private final static String separator = "separator";
    public TableWritablePrepared(String [] args) {
        this.args = args;
    }

    public void write() {
        try (Connection connection = new MysqlConnector().getConnection()){
            PreparedStatement preparedStatementReceivers = connection
                    .prepareStatement("INSERT INTO receivers (receiver) VALUES (?)");
            int k = 0;
            for (int i = 0; i < args.length; i++) {
                if (!args[i].equals(separator)) {
                    preparedStatementReceivers.setString(1,args[i]);
                    preparedStatementReceivers.executeUpdate();
                } else {
                    k = i;
                    k++;
                    break;
                }
            }

            PreparedStatement preparedStatementExpenses = connection
                    .prepareStatement("INSERT INTO expenses (paydate, receiver_id, expense) VALUES (?,?,?)");
            for (int i = k; i < args.length;i++) {
                preparedStatementExpenses.setDate(1,Date.valueOf(args[i]));
                preparedStatementExpenses.setInt(2,Integer.parseInt(args[++i]));
                preparedStatementExpenses.setDouble(3,Double.parseDouble(args[++i]));
                preparedStatementExpenses.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
