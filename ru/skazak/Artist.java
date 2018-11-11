package ru.skazak;

import java.util.ArrayList;

class Artist {
    private String title;
    private ArrayList<Album> albums;

    Artist(String title) {
        this.title = title;
        this.albums = new ArrayList<Album>();
    }

    String getTitle() {
        return title;
    }

    ArrayList<Album> getAlbums() {
        return albums;
    }

    void addAlbum(Album album) {
        albums.add(album);
    }
}