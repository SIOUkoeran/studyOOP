package ch07합성.동시수정문제;

import ch06.동시수정문제.Playlist;
import ch06.동시수정문제.Song;

public class PersonPlaylist {
    private Playlist playlist = new Playlist();

    public void append(Song song){
        playlist.append(song);
    }

    public void remove(Song song){
        playlist.getTracks().remove(song);
        playlist.getTracks().remove(song.getSinger());
    }
}
