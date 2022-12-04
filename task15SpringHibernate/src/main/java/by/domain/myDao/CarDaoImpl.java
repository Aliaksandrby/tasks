package by.domain.myDao;

import by.domain.myModel.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Car car) {
        sessionFactory.getCurrentSession().saveOrUpdate(car);
    }

    @Override
    public Car findById(int id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    @Override
    public List<Car> readAll() {
        String query = "from Car";
        return sessionFactory.getCurrentSession().createQuery(query, Car.class).list();
    }

    @Override
    public void delete(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.refresh(car);
        session.delete(car);
    }
}
