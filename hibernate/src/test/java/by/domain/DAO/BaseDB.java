package by.domain.DAO;

import by.domain.conf.MysqlJdbcDataSource;
import by.domain.pojo.Song;
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
        testMysqlJdbcDataSource = new MysqlJdbcDataSource("hi_db_test.jdbc.properties");
        iDatabaseConnection = new MySqlConnection(testMysqlJdbcDataSource.getConnection(), "hi_db_test");

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hi_db_test.xml")
                .build();
        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass( Song.class )
                .getMetadataBuilder()
                .build();
        testSessionFactory = metadata.getSessionFactoryBuilder()
                .build();
    }
}
