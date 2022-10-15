package by.domain.model;

import java.util.Objects;

public class Receiver {
    private int receiverId;
    private String receiver;

    public Receiver() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver1 = (Receiver) o;
        return receiverId == receiver1.receiverId && Objects.equals(receiver, receiver1.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiverId, receiver);
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
