/*
* Задание 8:
* Создайте структуру наследования, при которой у вас будет базовый класс и
* наследники.
* 1. Настройте отображение и реализуйте стратегию иерархии в одной таблице; (table per class hierarchy).
* 2. Настройте отображение и реализуйте стратегию таблица на подкласс; (table per subclass).
* 3. Настройте отображение и реализуйте стратегию таблица на конкретный класс; (table per concrete class).
* Напишите логику по внесению и извлечению различных сущностей из этой иерархии. (стр 125)
*
*/

package by.domain.run;

import by.domain.DAO.Dao;
import by.domain.DAO.DaoImpl;
import by.domain.conf.DataConfig;
import by.domain.conf.MysqlSessionFactory;
import by.domain.tablePerClassHierarchy.pojo.Device;
import by.domain.tablePerClassHierarchy.pojo.FlashCard;
import by.domain.tablePerClassHierarchy.pojo.Player;
import by.domain.tablePerConcreteClass.pojo.Driver;
import by.domain.tablePerConcreteClass.pojo.Person;
import by.domain.tablePerConcreteClass.pojo.Programmer;
import by.domain.tablePerSubclass.pojo.Body;
import by.domain.tablePerSubclass.pojo.Car;
import by.domain.tablePerSubclass.pojo.Engine;
import org.hibernate.SessionFactory;

import java.util.List;

public class Task8ORM {
    public static void main(String[] args) {
        SessionFactory sessionFactory = MysqlSessionFactory.getInstance(
                        DataConfig.JDBC_PROPERTIES,
                        DataConfig.HIBERNATE_PROPERTIES
                );

        Dao<Device> deviceDao = new DaoImpl<>(sessionFactory);
        deviceDao.create(new FlashCard(null,"dell",5,"ext4",500,600));
        deviceDao.create(new Player(null,"samsung","android",5,"IPS"));

        List<Device> deviceList = deviceDao.readNotes("from Device");
        for (Device element : deviceList) {
            System.out.println(element);
        }


        Dao<Car> carDao = new DaoImpl<>(sessionFactory);
        Car car = new Body(null,"Volkswagen Group","limousine","yellow",6);
        carDao.create(car);
        car = new Engine(null,"General Motors","gas",8,300);
        carDao.create(car);

        List<Car> carList = carDao.readNotes("from Car");
        for (Car element : carList) {
            System.out.println(element);
        }

        Dao<Person> dao = new DaoImpl<>(sessionFactory);
        Person person = new Person(null,"name","surname");
        dao.create(person);
        Programmer programmer = new Programmer(null,"name","surname","algol");
        dao.create(programmer);
        person = new Driver(null,"George","surname","mercedes");
        dao.create(person);

        List<Person> personList = dao.readNotes("from Person");
        for (Person element : personList) {
            System.out.println(element);
        }

    }
}
