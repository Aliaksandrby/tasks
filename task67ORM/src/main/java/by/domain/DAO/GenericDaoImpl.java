package by.domain.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private final SessionFactory sessionFactory;

    public GenericDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(T entityClass) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(entityClass);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<T> readAll(String query) {
        Session session = sessionFactory.openSession();
        List<T> list = session.createQuery(query).list();
        session.close();
        return list;
    }
}
