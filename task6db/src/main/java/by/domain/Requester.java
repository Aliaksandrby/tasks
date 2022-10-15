package by.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Requester {

    public final static String sqlFirst = "SELECT receiver,expense FROM expenses e INNER JOIN" +
            " receivers r ON e.receiver_id=r.receiver_id";
    public final static String sqlSecond = "SELECT paydate,SUM(expense) expense FROM expenses WHERE" +
            " paydate=(SELECT paydate FROM expenses WHERE expense=(SELECT MAX(expense) FROM expenses))";
    public final static String sqlThird = "SELECT paydate,MAX(expense) expense FROM expenses WHERE" +
            " paydate=(SELECT paydate FROM expenses GROUP BY paydate ORDER BY SUM(expense) DESC LIMIT 1)";

    public static void generalSqlRequest(String sqlRequest,String field1,String field2) {
        try (Connection connection = new MysqlConnector().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlRequest);

            System.out.println("+------------------------------+---------------+");
            System.out.printf("|%30s|%15s|\n", field1, field2);
            System.out.println("+------------------------------+---------------+");
            while (resultSet.next()) {
                System.out.printf("|%30s|%15.2f|\n", resultSet.getString(field1), resultSet.getDouble(field2));
            }
            System.out.println("+------------------------------+---------------+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void first() {
        try (Connection connection = new MysqlConnector().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlFirst);

            System.out.println("+------------------------------+------------+");
            System.out.printf("|%30s|%12s|\n", "receiver", "expense");
            System.out.println("+------------------------------+------------+");
            while (resultSet.next()) {
                String receiver = resultSet.getString("receiver");
                double expense = resultSet.getDouble("expense");
                System.out.printf("|%30s|%12.2f|\n", receiver, expense);
            }
            System.out.println("+------------------------------+------------+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void second() {
        try (Connection connection = new MysqlConnector().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSecond);

            System.out.println("+----------+------------+");
            System.out.printf("|%10s|%12s|\n", "paydate", "SUM(expense)");
            System.out.println("+----------+------------+");
            while (resultSet.next()) {
                String paydate = resultSet.getDate("paydate").toString();
                double expense = resultSet.getDouble("expense");
                System.out.printf("|%10s|%12.2f|\n", paydate, expense);
            }
            System.out.println("+----------+------------+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void third() {
        try (Connection connection = new MysqlConnector().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlThird);

            System.out.println("+----------+------------+");
            System.out.printf("|%10s|%12s|\n", "paydate", "MAX(expense)");
            System.out.println("+----------+------------+");
            while (resultSet.next()) {
                String paydate = resultSet.getDate("paydate").toString();
                double expense = resultSet.getDouble("expense");
                System.out.printf("|%10s|%12.2f|\n", paydate, expense);
            }
            System.out.println("+----------+------------+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
