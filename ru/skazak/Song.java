package ru.skazak;

class Song {
    private String title;
    private Album album;
    private Genre genre;

    Song(String title, Album album, Genre genre) {
        this.title = title;
        this.album = album;
        this.genre = genre;
    }

    String getTitle() {
        return title;
    }

    Album getAlbum() {
        return album;
    }

    Genre getGenre() {
        return genre;
    }
}
