package by.domain.inout;

import by.domain.dao.ExpRecDAO;
import by.domain.model.Expense;
import by.domain.model.Receiver;

import java.sql.Date;
import java.util.List;

public class Result {

    public static void showListExpenses(ExpRecDAO expRecDAO) {
        List<Expense> expenses = expRecDAO.getExpenses();
        System.out.println("+----------+----------+------------+----------+");
        System.out.printf("|%10s|%10s|%12s|%10s|\n", "payment_id", "paydate", "receiver_id", "expense");
        System.out.println("+----------+----------+------------+----------+");
        for (Expense element : expenses) {
            System.out.printf("|%10d|%10s|%12s|%10.2f|\n", element.getPaymentId(), element.getPayDate(), element.getReceiverId(), element.getExpense());
        }
        System.out.println("+----------+----------+------------+----------+");
    }

    public static void showListReceivers(ExpRecDAO expRecDAO) {
        List<Receiver> receivers = expRecDAO.getReceivers();
        System.out.println("+------------+------------------------------+");
        System.out.printf("|%12s|%30s|\n", "receiver_id", "receiver");
        System.out.println("+------------+------------------------------+");
        for (Receiver element : receivers) {
            System.out.printf("|%12d|%30s|\n", element.getReceiverId(), element.getReceiver());
        }
        System.out.println("+------------+------------------------------+");
    }

    public static void showExpense(ExpRecDAO expRecDAO,int number) {
        Expense expense = expRecDAO.getExpense(number);
        System.out.println("+----------+----------+------------+----------+");
        System.out.printf("|%10s|%10s|%12s|%10s|\n", "payment_id", "paydate", "receiver_id", "expense");
        System.out.println("+----------+----------+------------+----------+");
        System.out.printf("|%10d|%10s|%12s|%10.2f|\n", expense.getPaymentId(), expense.getPayDate(),
                expense.getReceiverId(), expense.getExpense());
        System.out.println("+----------+----------+------------+----------+");
    }

    public static void showReceiver(ExpRecDAO expRecDAO,int number) {
        Receiver receiver = expRecDAO.getReceiver(number);
        System.out.println("+------------+------------------------------+");
        System.out.printf("|%12s|%30s|\n", "receiver_id", "receiver");
        System.out.println("+------------+------------------------------+");
        System.out.printf("|%12d|%30s|\n", receiver.getReceiverId(), receiver.getReceiver());
        System.out.println("+------------+------------------------------+");
    }

    public static void showNumberAddedReceiver(ExpRecDAO expRecDAO,String receiverName) {
        Receiver receiver = new Receiver();
        receiver.setReceiver(receiverName);
        System.out.println("Added note into receiver : " + expRecDAO.addReceiver(receiver));
    }

    public static void showNumberAddedExpense(ExpRecDAO expRecDAO,String paydate,int receiverId,double expensePay) {
        Expense expense = new Expense();
        expense.setPayDate(Date.valueOf(paydate));
        expense.setReceiverId(receiverId);
        expense.setExpense(expensePay);
        System.out.println("Added note into expense : " + expRecDAO.addExpense(expense));
    }

}
