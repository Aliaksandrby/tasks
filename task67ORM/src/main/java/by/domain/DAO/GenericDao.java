package by.domain.DAO;

import java.util.List;

public interface GenericDao<T> {
    void create(T t);
    List<T> readAll(String query);
}