package by.domain.DAO;

import by.domain.conf.DataConfig;
import by.domain.conf.MysqlJdbcDataSource;
import by.domain.pojo.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SongDaoImpl implements SongDao{

    private final Session session;

    public SongDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveSong(Song song) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void saveSong(String nameEntity, Song song) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(nameEntity,song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    //method is standard jdbc; load and get looks SongDaoContinueImpl;
    @Override
    public Song findSongById(Integer id) {
        Song song = null;
        try (Connection connection = new MysqlJdbcDataSource(DataConfig.JDBC_PROPERTIES).getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM songs WHERE id=" + id);
            resultSet.next();
            song = new Song(
                resultSet.getInt("id"), resultSet.getString("name_song"),
                resultSet.getString("singer"), resultSet.getString("genre"),
                resultSet.getInt("duration")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return song;
    }

    @Override
    public void deleteSong(Song song) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSong(String nameEntity, Song song) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(nameEntity,song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Song getObjFromDB(Integer id) {
        return session.get(Song.class, id);
    }

    @Override
    public Song loadObjFromDB(Integer id) {
        return session.load(Song.class, id);
    }
}
