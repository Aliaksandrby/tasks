package by.domain.run;

import by.domain.pojo.Song;

import java.util.ArrayList;
import java.util.List;

public class SongList {
    private final List<Song> songs = new ArrayList<>();
    public SongList(int capacity) {
        for (int i = 1; i <= capacity; i++) {
            songs.add(new Song(null,"song_" + i,"singer_" + i,"genre_" + i,3));
        }
    }

    public List<Song> getSongs() {
        return songs;
    }
}
