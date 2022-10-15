/*
 * Создайте объект DAO на основе интерфейса, приведенного выше.
 * Также необходимо создать классы Receiver и Expense, свойства которых
 * соответствуют полям таблиц базы данных расходов. Поле дата в классах можно хранить
 * в виде строки.
 */

package by.domain.inout;

import by.domain.dao.*;

public class Main {
    public static void main(String[] args) {

        ExpRecDAO expRecDAO = ExpRecDAOImpl.getInstance();

        Result.showNumberAddedReceiver(expRecDAO,"some receiver");
        Result.showNumberAddedExpense(expRecDAO,"2011-08-27",8,54.5);

        Result.showListExpenses(expRecDAO);
        Result.showListReceivers(expRecDAO);

        Result.showExpense(expRecDAO,4);
        Result.showReceiver(expRecDAO,8);

    }
}
