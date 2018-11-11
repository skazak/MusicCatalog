package ru.skazak;

import java.util.ArrayList;
import java.util.HashSet;

class Finder {

    private HashSet<Genre> getAllSubgenres(Genre g) {
        HashSet<Genre> result = new HashSet<Genre>();
        result.add(g);
        for (Genre genre : g.getSubgenres()) {
            result.addAll(getAllSubgenres(genre));
        }
        return result;
    }

    // Artists
    private ArrayList<Artist> findArtistsByTitle(ArrayList<Artist> artists, String title) {
        ArrayList<Artist> result = new ArrayList<Artist>();
        for (Artist artist : artists) {
            if (artist.getTitle().toLowerCase().equals(title.toLowerCase())) {
                result.add(artist);
            }
        }
        return result;
    }

    // Mixtapes
    private ArrayList<Mixtape> findMixtapesByTitle(ArrayList<Mixtape> mixtapes, String title) {
        ArrayList<Mixtape> result = new ArrayList<Mixtape>();
        for (Mixtape mixtape : mixtapes) {
            if (mixtape.getTitle().toLowerCase().equals(title.toLowerCase())) {
                result.add(mixtape);
            }
        }
        return result;
    }

    private ArrayList<Mixtape> findMixtapesByYear(ArrayList<Mixtape> mixtapes, int year) {
        ArrayList<Mixtape> result = new ArrayList<Mixtape>();
        for (Mixtape mixtape : mixtapes) {
            if (mixtape.getReleaseYear() == year) {
                result.add(mixtape);
            }
        }
        return result;
    }

    // Albums
    private ArrayList<Album> findAlbumsByTitle(ArrayList<Album> albums, String title) {
        ArrayList<Album> result = new ArrayList<Album>();
        for (Album album : albums) {
            if (album.getTitle().toLowerCase().equals(title.toLowerCase())) {
                result.add(album);
            }
        }
        return result;
    }

    // Songs

    private ArrayList<Song> findSongsInMixtapesByTitle(ArrayList<Mixtape> mixtapes, String title) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Mixtape mixtape : mixtapes) {
            for (Song song : mixtape.getSongs()) {
                if (song.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    result.add(song);
                }
            }
        }
        return result;
    }

    private ArrayList<Song> findSongsInMixtapesByYear(ArrayList<Mixtape> mixtapes, int year) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Mixtape mixtape : mixtapes) {
            for (Song song : mixtape.getSongs()) {
                if (song.getAlbum().getReleaseYear() == year) {
                    result.add(song);
                }
            }
        }
        return result;
    }

    private ArrayList<Song> findSongsInMixtapesByGenre(ArrayList<Mixtape> mixtapes, Genre genre) {
        ArrayList<Song> result = new ArrayList<Song>();
        HashSet<Genre> genresToFind = getAllSubgenres(genre);
        for (Mixtape mixtape : mixtapes) {
            for (Song song : mixtape.getSongs()) {
                if (genresToFind.contains(song.getGenre())) {
                    result.add(song);
                }
            }
        }
        return result;
    }

    private ArrayList<Song> findSongsByTitle(ArrayList<Song> songs, String title) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().equals(title.toLowerCase())) {
                result.add(song);
            }
        }
        return result;
    }

    private ArrayList<Song> findSongsByYear(ArrayList<Song> songs, int year) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song song : songs) {
            if (song.getAlbum().getReleaseYear() == year) {
                result.add(song);
            }
        }
        return result;
    }

    private ArrayList<Song> findSongsByGenre(ArrayList<Song> songs, Genre genre) {
        ArrayList<Song> result = new ArrayList<Song>();
        HashSet<Genre> genresToFind = getAllSubgenres(genre);
        for (Song song : songs) {
            if (genresToFind.contains(song.getGenre())) {
                result.add(song);
            }
        }
        return result;
    }


    // Find method
    ArrayList<Song> findSongs(ArrayList<Artist> artists, String artistName, String albumTitle, String songTitle, Genre genre, int releaseYear) {
        ArrayList<Album> albums = new ArrayList<Album>();
        ArrayList<Song> songs = new ArrayList<Song>();
        if (artistName.isEmpty()) {
            for (Artist a : artists) {
                albums.addAll(a.getAlbums());
            }
        } else {
            for (Artist a : findArtistsByTitle(artists, artistName)) {
                albums.addAll(a.getAlbums());
            }
        }

        if (albumTitle.isEmpty()) {
            for (Album album : albums) {
                songs.addAll(album.getSongs());
            }
        } else {
            for (Album album : findAlbumsByTitle(albums, albumTitle)) {
                songs.addAll(album.getSongs());
            }
        }

        if (!songTitle.isEmpty()) {
            songs = findSongsByTitle(songs, songTitle);
        }

        if (genre != null) {
            songs = findSongsByGenre(songs, genre);
        }

        if (releaseYear != -1) {
            songs = findSongsByYear(songs, releaseYear);
        }

        return songs;
    }

}
