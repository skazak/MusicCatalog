package ru.skazak;

import java.util.ArrayList;

class Album {
    private String title;
    private Artist artist;
    private int releaseYear;
    private ArrayList<Song> songs;

    Album(String title, Artist artist, int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.songs = new ArrayList<Song>();
    }

    void addSong(Song song) {
        songs.add(song);
    }

    String getTitle() {
        return title;
    }

    Artist getArtist() {
        return artist;
    }

    int getReleaseYear() {
        return releaseYear;
    }

    ArrayList<Song> getSongs() {
        return songs;
    }
}
