package by.domain.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DaoImpl<T> implements Dao<T> {

    private final SessionFactory sessionFactory;

    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<T> readNotes(String query) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(query).list();
        }
    }
}
