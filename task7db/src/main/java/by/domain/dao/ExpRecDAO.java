package by.domain.dao;


import by.domain.model.Expense;
import by.domain.model.Receiver;

import java.util.List;

public interface ExpRecDAO {
    List<Receiver> getReceivers();
    List<Expense> getExpenses();
    Receiver getReceiver(int num);
    Expense getExpense(int num);
    int addReceiver(Receiver receiver);
    int addExpense(Expense expense);
}
