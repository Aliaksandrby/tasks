package by.domain.DAO;

import by.domain.conf.MysqlJdbcDataSource;
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
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlConnection;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.BeforeClass;

public class BaseDB {
    // JDBC data source
    static MysqlJdbcDataSource testMysqlJdbcDataSource;
    // DBUnit connection
    static IDatabaseConnection iDatabaseConnection;
    //Hibernate session factory
    static SessionFactory testSessionFactory;

    @BeforeClass
    @SneakyThrows
    public static void init() {
        testMysqlJdbcDataSource = new MysqlJdbcDataSource("orm8_db_test.jdbc.properties");
        iDatabaseConnection = new MySqlConnection(testMysqlJdbcDataSource.getConnection(), "orm8_db_test");

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("orm8_db_test.xml")
                .build();
        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass(Device.class)
                .addAnnotatedClass(FlashCard.class)
                .addAnnotatedClass(Player.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Body.class)
                .addAnnotatedClass(Engine.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Driver.class)
                .addAnnotatedClass(Programmer.class)
                .getMetadataBuilder()
                .build();
        testSessionFactory = metadata.getSessionFactoryBuilder()
                .build();
    }
}
