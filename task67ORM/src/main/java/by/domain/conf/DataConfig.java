package by.domain.conf;

import lombok.SneakyThrows;

import java.util.Properties;

public class DataConfig {

    public static final String JDBC_PROPERTIES = "orm67_db.jdbc.properties";
    public static final String HIBERNATE_PROPERTIES = "orm67_db.hibernate.properties";

    private static Properties jdbcProperties;
    private static Properties hibernateProperties;

    @SneakyThrows
    public static Properties getJdbcProperties(String propertyFile) {
        if (jdbcProperties == null) {
            jdbcProperties = new Properties();
            jdbcProperties
                    .load(MysqlJdbcDataSource.class
                            .getClassLoader()
                            .getResourceAsStream(propertyFile));
        }
        return jdbcProperties;
    }

    @SneakyThrows
    public static Properties getHibernateProperties(String propertyFile) {
        if (hibernateProperties == null) {
            hibernateProperties = new Properties();
            hibernateProperties
                    .load(MysqlJdbcDataSource.class
                            .getClassLoader()
                            .getResourceAsStream(propertyFile));
        }
        return hibernateProperties;
    }
}