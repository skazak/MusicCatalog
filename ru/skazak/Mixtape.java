package ru.skazak;

import java.util.ArrayList;
import java.util.Date;

class Mixtape {
    private String title;
    private int releaseYear;
    private ArrayList<Song> songs;

    Mixtape(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.songs = new ArrayList<Song>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    String getTitle() {
        return title;
    }

    int getReleaseYear() {
        return releaseYear;
    }

    ArrayList<Song> getSongs() {
        return songs;
    }

}
