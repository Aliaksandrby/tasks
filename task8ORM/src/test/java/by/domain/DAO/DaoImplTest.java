package by.domain.DAO;

import by.domain.tablePerClassHierarchy.pojo.Device;
import by.domain.tablePerClassHierarchy.pojo.FlashCard;
import by.domain.tablePerClassHierarchy.pojo.Player;
import by.domain.tablePerConcreteClass.pojo.Driver;
import by.domain.tablePerConcreteClass.pojo.Person;
import by.domain.tablePerConcreteClass.pojo.Programmer;
import by.domain.tablePerSubclass.pojo.Body;
import by.domain.tablePerSubclass.pojo.Car;
import by.domain.tablePerSubclass.pojo.Engine;
import lombok.SneakyThrows;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.*;

public class DaoImplTest extends BaseDB{

    Dao<Device> targetObjectDevice;

    Dao<Car> targetObjectCar;
    Dao<Body> targetObjectBody;
    Dao<Engine> targetObjectEngine;

    Dao<Person> targetObjectPerson;
    Dao<Programmer> targetObjectProgrammer;
    Dao<Driver> targetObjectDriver;

    @Before
    public void setUp() {
        targetObjectDevice = new DaoImpl<>(testSessionFactory);

        targetObjectCar = new DaoImpl<>(testSessionFactory);
        targetObjectBody = new DaoImpl<>(testSessionFactory);
        targetObjectEngine = new DaoImpl<>(testSessionFactory);

        targetObjectPerson = new DaoImpl<>(testSessionFactory);
        targetObjectProgrammer = new DaoImpl<>(testSessionFactory);
        targetObjectDriver = new DaoImpl<>(testSessionFactory);

    }

    @After
    public void tearDown() {
        targetObjectDevice = null;

        targetObjectCar = null;
        targetObjectBody = null;
        targetObjectEngine = null;

        targetObjectPerson = null;
        targetObjectProgrammer = null;
        targetObjectDriver = null;
    }

    @Test
    @SneakyThrows
    public void createTablePerClassHierarchy() {
        //Given
        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from t_device;");
        resultSet.next();
        int initialSizeDevice = resultSet.getInt(1);
        assertEquals(0, initialSizeDevice);

        //When
        targetObjectDevice.create(new FlashCard(null,"dell",5,"ext4",500,600));
        targetObjectDevice.create(new Player(null,"samsung","android",5,"IPS"));

        //Then
        resultSet = connection.createStatement().executeQuery("select count(*) from t_device;");
        resultSet.next();
        int actualSizeDevice = resultSet.getInt(1);
        assertEquals(2, actualSizeDevice);

        connection.createStatement().executeUpdate("truncate table t_device;");
        connection.close();
    }

    @Test
    @SneakyThrows
    public void readNotesTablePerClassHierarchy() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(DaoImplTest.class.getResourceAsStream("DaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<Device> deviceList = targetObjectDevice.readNotes("from Device");

        //Then
        assertEquals(2, deviceList.size());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void createTablePerSubclass() {
        //Given
        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from t_car;");
        resultSet.next();
        int initialSizeCar = resultSet.getInt(1);
        assertEquals(0, initialSizeCar);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_body;");
        resultSet.next();
        int initialSizeBody = resultSet.getInt(1);
        assertEquals(0, initialSizeBody);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_engine;");
        resultSet.next();
        int initialSizeEngine = resultSet.getInt(1);
        assertEquals(0, initialSizeEngine);

        //When
        Car car = new Body(null,"Audi","sedan","black",4);
        targetObjectCar.create(car);
        car = new Engine(null,"reno engine","disel",7,200);
        targetObjectCar.create(car);

        //Then
        resultSet = connection.createStatement().executeQuery("select count(*) from t_car;");
        resultSet.next();
        int actualSizeCar = resultSet.getInt(1);
        assertEquals(2, actualSizeCar);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_body;");
        resultSet.next();
        int actualSizeBody = resultSet.getInt(1);
        assertEquals(1, actualSizeBody);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_engine;");
        resultSet.next();
        int actualSizeEngine = resultSet.getInt(1);
        assertEquals(1, actualSizeEngine);

        connection.createStatement().execute("delete from t_body;");
        connection.createStatement().execute("delete from t_engine;");
        connection.createStatement().execute("delete from t_car;");

        connection.close();
    }

    @Test
    @SneakyThrows
    public void readNotesTablePerSubclass() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(DaoImplTest.class.getResourceAsStream("DaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<Car> carList = targetObjectCar.readNotes("from Car");
        List<Body> bodyList = targetObjectBody.readNotes("from Body");
        List<Engine> engineList = targetObjectEngine.readNotes("from Engine");

        //Then
        assertEquals(2, carList.size());
        assertEquals("1", carList.get(0).getId().toString());
        assertEquals("2", carList.get(1).getId().toString());
        assertEquals("mercedes engine", carList.get(0).getProducer());
        assertEquals("toyota", carList.get(1).getProducer());

        assertEquals(1, bodyList.size());
        assertEquals("2", bodyList.get(0).getId().toString());
        assertEquals("grey", bodyList.get(0).getColor());
        assertEquals(10, bodyList.get(0).getNumberOfDoors());
        assertEquals("sedan", bodyList.get(0).getTypeOfBody());

        assertEquals(1, engineList.size());
        assertEquals("1", engineList.get(0).getId().toString());
        assertEquals("h2o", engineList.get(0).getTypeOfEngine());
        assertEquals(5, engineList.get(0).getNumberOfCylinders());
        assertEquals(300, engineList.get(0).getPower());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void createTablePerConcreteClass() {
        //Given
        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from t_person;");
        resultSet.next();
        int initialSizePerson = resultSet.getInt(1);
        assertEquals(0, initialSizePerson);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_programmer;");
        resultSet.next();
        int initialSizeProgrammer = resultSet.getInt(1);
        assertEquals(0, initialSizeProgrammer);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_driver;");
        resultSet.next();
        int initialSizeDriver = resultSet.getInt(1);
        assertEquals(0, initialSizeDriver);

        //When
        Person person = new Person(null,"George","Clooney");
        targetObjectPerson.create(person);
        Programmer programmer = new Programmer(null,"Michael","Douglas","algol");
        targetObjectPerson.create(programmer);
        Driver driver = new Driver(null,"Sharon","Stone","mercedes");
        targetObjectPerson.create(driver);

        //Then
        resultSet = connection.createStatement().executeQuery("select count(*) from t_person;");
        resultSet.next();
        int actualSizePerson = resultSet.getInt(1);
        assertEquals(1, actualSizePerson);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_programmer;");
        resultSet.next();
        int actualSizeProgrammer = resultSet.getInt(1);
        assertEquals(1, actualSizeProgrammer);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_driver;");
        resultSet.next();
        int actualSizeDriver = resultSet.getInt(1);
        assertEquals(1, actualSizeDriver);

        connection.createStatement().execute("delete from t_person;");
        connection.createStatement().execute("delete from t_programmer;");
        connection.createStatement().execute("delete from t_driver;");

        connection.close();
    }

    @Test
    @SneakyThrows
    public void readNotesTablePerConcreteClass() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(DaoImplTest.class.getResourceAsStream("DaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<Person> personList = targetObjectPerson.readNotes("from Person");
        List<Programmer> programmerList = targetObjectProgrammer.readNotes("from Programmer");
        List<Driver> driverList = targetObjectDriver.readNotes("from Driver");

        //Then
        assertEquals(3, personList.size());
        assertEquals("name_1", personList.get(0).getName());
        assertEquals("surname_1", personList.get(0).getSurname());

        assertEquals(1, programmerList.size());
        assertEquals("name_2", programmerList.get(0).getName());
        assertEquals("surname_2", programmerList.get(0).getSurname());
        assertEquals("java", programmerList.get(0).getLanguage());

        assertEquals(1, driverList.size());
        assertEquals("name_3", driverList.get(0).getName());
        assertEquals("surname_3", driverList.get(0).getSurname());
        assertEquals("car_3", driverList.get(0).getCarName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
}