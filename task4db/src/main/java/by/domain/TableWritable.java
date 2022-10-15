package by.domain;

import java.sql.*;

public class TableWritable {
    private final String [] args;
    private final static String separator = "separator";
    public TableWritable(String [] args) {
        this.args = args;
    }

    public void write() {
        try (Connection connection = new MysqlConnector().getConnection()) {
            Statement statement = connection.createStatement();
            int k = 0;
            for (int i = 0; i < args.length; i++) {
                if (!args[i].equals(separator)) {
                    statement.execute("INSERT INTO receivers (receiver) VALUES ('" + args[i] + "')");
                } else {
                    k = i;
                    k++;
                    break;
                }
            }
            for (int i = k; i < args.length;i++) {
                statement.execute("INSERT INTO expenses (paydate, receiver_id, expense) VALUES ('"
                            + args[i] + "'," + args[++i] + "," + args[++i] + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
