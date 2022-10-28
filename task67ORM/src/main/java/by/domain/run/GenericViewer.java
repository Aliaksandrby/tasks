package by.domain.run;

import by.domain.DAO.GenericDao;
import by.domain.DAO.GenericDaoImpl;
import by.domain.conf.DataConfig;
import by.domain.conf.MysqlSessionFactory;
import by.domain.pojo.Service;
import org.hibernate.SessionFactory;

import java.util.List;

public class GenericViewer<T extends Service> {

    private final SessionFactory sessionFactory = MysqlSessionFactory
            .getInstance(DataConfig.JDBC_PROPERTIES, DataConfig.HIBERNATE_PROPERTIES);

    public void genericShow(String hqlQuery) {
        GenericDao<T> genericDao = new GenericDaoImpl<>(sessionFactory);
        List<T> list = genericDao.readAll(hqlQuery);
        for (T element : list) {
            System.out.println("Entity " + element.getClass().getName() + " id: " + element.getId());
        }
    }
}
