package by.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Output {
    public static void setResult(ResultSet resultSet) throws SQLException {
        System.out.println("+----------+----------+------------------------------+----------+");
        System.out.printf("|%10s|%10s|%30s|%10s|\n", "payment_id", "paydate", "receiver", "expense");
        System.out.println("+----------+----------+------------------------------+----------+");
        while (resultSet.next()) {
            int payment_id = resultSet.getInt("payment_id");
            String paydate = resultSet.getDate("paydate").toString();
            String receiver = resultSet.getString("receiver");
            double expense = resultSet.getDouble("expense");
            System.out.printf("|%10d|%10s|%30s|%10.2f|\n", payment_id, paydate, receiver, expense);
        }
        System.out.println("+----------+----------+------------------------------+----------+");
    }
}
