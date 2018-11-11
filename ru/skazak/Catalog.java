package ru.skazak;

import java.util.ArrayList;
import java.util.HashSet;

class Catalog {

    private static final Catalog instance = new Catalog();


    private ArrayList<Genre> genres;
    private ArrayList<Artist> artists;
    private ArrayList<Mixtape> mixtapes;


    private Catalog() {
        artists = new ArrayList<Artist>();
        mixtapes = new ArrayList<Mixtape>();
        genres = new ArrayList<Genre>();

        genres.add(new Genre("Rock"));
        genres.add(new Genre("Rap"));
        genres.add(new Genre("Pop"));

        genres.get(0).addSubgenre(new Genre("Hard Rock"));
        genres.get(1).addSubgenre(new Genre("Gangsta Rap"));
        genres.get(1).addSubgenre(new Genre("Trip-Hop"));

    }

    static Catalog getInstance() {
        return instance;
    }

    void addArtist(Artist artist) {
        artists.add(artist);
    }

    void addMixtape(Mixtape mixtape) {
        mixtapes.add(mixtape);
    }

    ArrayList<Artist> getArtists() {
        return artists;
    }

    ArrayList<Mixtape> getMixtapes() {
        return mixtapes;
    }

    private ArrayList<Genre> getRootGenres() {
        return genres;
    }

    private HashSet<Genre> getAllSubgenres(Genre g) {
        HashSet<Genre> result = new HashSet<Genre>();
        result.add(g);
        for (Genre genre : g.getSubgenres()) {
            result.addAll(getAllSubgenres(genre));
        }
        return result;
    }

    private HashSet<Genre> getAllGenres(ArrayList<Genre> genres) {
        HashSet<Genre> result = new HashSet<Genre>();
        for (Genre genre : genres) {
            result.addAll(getAllSubgenres(genre));
        }
        return result;
    }

    Genre getGenre(String name) {
        for (Genre g : getAllGenres(genres)) {
            if (g.getTitle().toLowerCase().equals(name.toLowerCase())) {
                return g;
            }
        }
        return null;
    }

}
