package by.domain.dao;

import by.domain.MysqlDataSource;
import by.domain.model.Expense;
import by.domain.model.Receiver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpRecDAOImpl implements ExpRecDAO {

    private static ExpRecDAOImpl instance;

    private ExpRecDAOImpl() {

    }

    public static ExpRecDAOImpl getInstance() {
        if(instance == null) {
            instance = new ExpRecDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Receiver> getReceivers() {
        List<Receiver> receivers = new ArrayList<>();
        try (Connection connection = new MysqlDataSource().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM receivers");
            while (resultSet.next()) {
                Receiver receiver = new Receiver();
                receiver.setReceiverId(resultSet.getInt("receiver_id"));
                receiver.setReceiver(resultSet.getString("receiver"));
                receivers.add(receiver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receivers;
    }

    @Override
    public List<Expense> getExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try (Connection connection = new MysqlDataSource().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM expenses");
            while (resultSet.next()) {
                Expense expense = new Expense();
                expense.setPaymentId(resultSet.getInt("payment_id"));
                expense.setPayDate(resultSet.getDate("paydate"));
                expense.setReceiverId(resultSet.getInt("receiver_id"));
                expense.setExpense(resultSet.getDouble("expense"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public Receiver getReceiver(int num) {
        List<Receiver> receivers = getReceivers();
        Checker.checkList(num,receivers,"receivers");
        return receivers.get(num-1);
    }

    @Override
    public Expense getExpense(int num) {
        List<Expense> expenses = getExpenses();
        Checker.checkList(num,expenses,"expenses");
        return expenses.get(num-1);
    }

    @Override
    public int addReceiver(Receiver receiver) {
        int addedNote = 0;
        try (Connection connection = new MysqlDataSource().getConnection()){
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO receivers (receiver) VALUES('" + receiver.getReceiver() + "')");
            ResultSet resultSet = statement.executeQuery("SELECT MAX(receiver_id) FROM receivers");
            while(resultSet.next()) {
                addedNote = resultSet.getInt("MAX(receiver_id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addedNote;
    }

    @Override
    public int addExpense(Expense expense) {
        int addedNote = 0;
        try (Connection connection = new MysqlDataSource().getConnection()){
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO expenses (paydate,receiver_id,expense)" +
                    " VALUES('"+expense.getPayDate() + "'," + expense.getReceiverId() + "," + expense.getExpense() + ")");
            ResultSet resultSet = statement.executeQuery("SELECT MAX(payment_id) FROM expenses");
            while(resultSet.next()) {
                addedNote = resultSet.getInt("MAX(payment_id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addedNote;
    }
}
