package by.domain.DAO;

import java.util.List;

public interface Dao<T> {
    void create(T entity);
    List<T> readNotes(String query);
}
