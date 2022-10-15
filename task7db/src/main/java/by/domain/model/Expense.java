package by.domain.model;

import java.sql.Date;
import java.util.Objects;

public class Expense {
    private int paymentId;
    private Date payDate;
    private int receiverId;
    private double expense;

    public Expense() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense1 = (Expense) o;
        return paymentId == expense1.paymentId && receiverId == expense1.receiverId && Double.compare(expense1.expense, expense) == 0 && Objects.equals(payDate, expense1.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, payDate, receiverId, expense);
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }
}
