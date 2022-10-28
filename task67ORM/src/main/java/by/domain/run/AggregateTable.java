package by.domain.run;

import by.domain.DAO.GenericDao;
import by.domain.DAO.GenericDaoImpl;
import by.domain.conf.DataConfig;
import by.domain.conf.MysqlSessionFactory;
import org.hibernate.SessionFactory;
import java.util.List;

public class AggregateTable<T> {
    private final SessionFactory sessionFactory = MysqlSessionFactory
            .getInstance(DataConfig.JDBC_PROPERTIES, DataConfig.HIBERNATE_PROPERTIES);

    public void fill(List<T> list) {
        GenericDao<T> entityDao = new GenericDaoImpl<>(sessionFactory);
        for (T element : list) entityDao.create(element);
    }
}
