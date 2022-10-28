package by.domain.DAO;

import by.domain.pojo.Book;
import by.domain.pojo.Car;
import by.domain.pojo.SmartWatch;
import by.domain.pojo.addingfield.AddingBook;
import by.domain.pojo.addingfield.AddingCar;
import by.domain.pojo.addingfield.AddingWatch;
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

public class GenericDaoImplTest extends BaseDB{

    GenericDao<Car> targetObjectCar;
    GenericDao<Book> targetObjectBook;
    GenericDao<SmartWatch> targetObjectWatch;

    @Before
    public void setUp() {
        targetObjectCar = new GenericDaoImpl<>(testSessionFactory);
        targetObjectBook = new GenericDaoImpl<>(testSessionFactory);
        targetObjectWatch = new GenericDaoImpl<>(testSessionFactory);
    }

    @After
    public void tearDown() {
        targetObjectCar = null;
        targetObjectBook = null;
        targetObjectWatch = null;
    }

    @Test
    @SneakyThrows
    public void create() {
        //Given
        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from t_book;");
        resultSet.next();
        int initialSizeBook = resultSet.getInt(1);
        assertEquals(0, initialSizeBook);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_car;");
        resultSet.next();
        int initialSizeCar = resultSet.getInt(1);
        assertEquals(0, initialSizeCar);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_watch;");
        resultSet.next();
        int initialSizeWatch = resultSet.getInt(1);
        assertEquals(0, initialSizeWatch);

        //When
        Book book = new Book(null,"book test",
                new AddingBook("Bert Bates",2015,"O'Reilly Media"));
        targetObjectBook.create(book);

        Car car = new Car(null,"brand test","model test",
                new AddingCar("robot",3,"red"));
        targetObjectCar.create(car);

        SmartWatch smartWatch = new SmartWatch(null,"brand test","type of system test",56,
                new AddingWatch(32,"Li-ON",2));
        targetObjectWatch.create(smartWatch);

        //Then
        resultSet = connection.createStatement().executeQuery("select count(*) from t_book;");
        resultSet.next();
        int actualSizeBook = resultSet.getInt(1);
        assertEquals(1, actualSizeBook);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_car;");
        resultSet.next();
        int actualSizeCar = resultSet.getInt(1);
        assertEquals(1, actualSizeCar);

        resultSet = connection.createStatement().executeQuery("select count(*) from t_watch;");
        resultSet.next();
        int actualSizeWatch = resultSet.getInt(1);
        assertEquals(1, actualSizeWatch);

        connection.createStatement().executeUpdate("truncate table t_book;");
        connection.createStatement().executeUpdate("truncate table t_car;");
        connection.createStatement().executeUpdate("truncate table t_watch;");

        connection.close();
    }

    @Test
    @SneakyThrows
    public void readAll() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(GenericDaoImplTest.class.getResourceAsStream("GenericDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<Book> bookList = targetObjectBook.readAll("from Book");
        List<Car> carList = targetObjectCar.readAll("from Car");
        List<SmartWatch> watchList = targetObjectWatch.readAll("from Watch");

        //Then
        assertEquals(1, bookList.size());
        assertEquals("10", bookList.get(0).getId().toString());
        assertEquals("first book", bookList.get(0).getNameOfBook());
        assertEquals("some writer", bookList.get(0).getAddingBook().getWriter());
        assertEquals(2007, bookList.get(0).getAddingBook().getYearOfPublishing());
        assertEquals("publisher", bookList.get(0).getAddingBook().getPublishingOffice());

        assertEquals(1, carList.size());
        assertEquals("21", carList.get(0).getId().toString());
        assertEquals("good brand", carList.get(0).getBrand());
        assertEquals("excellent model", carList.get(0).getModel());
        assertEquals("robot", carList.get(0).getAddingCar().getTransmission());
        assertEquals(3, carList.get(0).getAddingCar().getEngineVolume());
        assertEquals("black", carList.get(0).getAddingCar().getColor());

        assertEquals(1, watchList.size());
        assertEquals("5", watchList.get(0).getId().toString());
        assertEquals("bad brand", watchList.get(0).getNameOfBrand());
        assertEquals("ms dos", watchList.get(0).getTypeSystem());
        assertEquals(9, watchList.get(0).getBodySize());
        assertEquals(64, watchList.get(0).getAddingWatch().getMemory());
        assertEquals("li-pol", watchList.get(0).getAddingWatch().getBatteryType());
        assertEquals(2, watchList.get(0).getAddingWatch().getScreenSize());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
}
