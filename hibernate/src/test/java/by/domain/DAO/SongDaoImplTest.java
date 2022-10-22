package by.domain.DAO;

import by.domain.pojo.Song;
import lombok.SneakyThrows;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.Assert.*;

public class SongDaoImplTest extends BaseDB {

    SongDao targetObj;
    private final String xmlDataSet = "SongDaoImplTest.xml";
    private final String nameEntity = "songs";

    @Before
    public void setUp() {
        targetObj = new SongDaoImpl(testSessionFactory.openSession());
    }

    @After
    public void tearDown() {
        targetObj = null;
    }

    @Test
    @SneakyThrows
    public void saveSong() {
        //Given
        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from songs;");
        resultSet.next();
        int initialSize = resultSet.getInt(1);
        assertEquals(0, initialSize);

        //When
        Song song = new Song(null,"song_test","singer_test","genre_test",-1);
        targetObj.saveSong(song);

        //Then
        resultSet = connection.createStatement().executeQuery("select count(*) from songs;");
        resultSet.next();
        int actualSize = resultSet.getInt(1);
        assertEquals(1, actualSize);
        connection.createStatement().executeUpdate("truncate table songs;");
        connection.close();
    }

    @Test
    @SneakyThrows
    public void saveSongOverloading() {
        //Given
        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from songs;");
        resultSet.next();
        int initialSize = resultSet.getInt(1);
        assertEquals(0, initialSize);

        //When
        Song song = new Song(null,"song_test","singer_test","genre_test",-1);
        targetObj.saveSong(nameEntity,song);

        //Then
        resultSet = connection.createStatement().executeQuery("select count(*) from songs;");
        resultSet.next();
        int actualSize = resultSet.getInt(1);
        assertEquals(1, actualSize);
        connection.createStatement().executeUpdate("truncate table songs;");
        connection.close();
    }

    @Test
    @SneakyThrows
    public void findSongById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(SongDaoImplTest.class.getResourceAsStream(xmlDataSet));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        int testId = 5;
        Song song = targetObj.findSongById(testId);
        System.out.println("obj: " + song);

        //Then
        assertEquals("song_" + testId, song.getNameSong());
        assertEquals("singer_" + testId, song.getSinger());
        assertEquals("genre_" + testId, song.getGenre());
        assertEquals(3, song.getDuration());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void deleteSong() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(SongDaoImplTest.class.getResourceAsStream(xmlDataSet));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from songs;");
        resultSet.next();
        int initialSize = resultSet.getInt(1);
        assertEquals(1, initialSize);

        //When
        Song song = new Song(5,"song_5","singer_5","genre_5",3);
        targetObj.deleteSong(song);

        //Then
        resultSet = connection.createStatement().executeQuery("select count(*) from songs;");
        resultSet.next();
        int actualSize = resultSet.getInt(1);
        assertEquals(0, actualSize);
        connection.close();
    }

    @Test
    @SneakyThrows
    public void deleteSongOverloading() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(SongDaoImplTest.class.getResourceAsStream(xmlDataSet));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from songs;");
        resultSet.next();
        int initialSize = resultSet.getInt(1);
        assertEquals(1, initialSize);

        //When
        Song song = new Song(5,"song_5","singer_5","genre_5",3);
        targetObj.deleteSong(nameEntity,song);

        //Then
        resultSet = connection.createStatement().executeQuery("select count(*) from songs;");
        resultSet.next();
        int actualSize = resultSet.getInt(1);
        assertEquals(0, actualSize);
        connection.close();
    }

    @Test
    @SneakyThrows
    public void getObjFromDB() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(SongDaoImplTest.class.getResourceAsStream(xmlDataSet));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        int testId = 5;
        //int testId = 19; // #java.lang.NullPointerException
        Song song = targetObj.getObjFromDB(testId);
        System.out.println("obj: " + song);

        //Then
        assertEquals("song_" + testId, song.getNameSong());
        assertEquals("singer_" + testId, song.getSinger());
        assertEquals("genre_" + testId, song.getGenre());
        assertEquals(3, song.getDuration());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void loadObjFromDB() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(SongDaoImplTest.class.getResourceAsStream(xmlDataSet));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        int testId = 5;
        //int testId = 13;
        /*
        #Tests in error:
        #loadObjFromDB(by.domain.DAO.SongDaoContinueImplTest):
        #No row with the given identifier exists: [by.domain.pojo.Song#13]
        */
        Song song = targetObj.loadObjFromDB(testId);
        System.out.println("obj: " + song);

        //Then
        assertEquals("song_" + testId, song.getNameSong());
        assertEquals("singer_" + testId, song.getSinger());
        assertEquals("genre_" + testId, song.getGenre());
        assertEquals(3, song.getDuration());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
}