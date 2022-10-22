package by.domain.DAO;

import by.domain.pojo.Song;

public interface SongDao {
    void saveSong(Song song);
    void saveSong(String nameEntity, Song song);
    Song findSongById(Integer id);
    void deleteSong(Song song);
    void deleteSong(String nameEntity, Song song);
    Song getObjFromDB(Integer id);
    Song loadObjFromDB(Integer id);
}
