package ru.skazak;

import java.util.ArrayList;
import java.util.HashSet;

class Genre {

    private String title;
    private ArrayList<Genre> subgenres;

    Genre(String title) {
        this.title = title;
        subgenres = new ArrayList<Genre>();
    }

    String getTitle() {
        return title;
    }

    ArrayList<Genre> getSubgenres() {
        return subgenres;
    }

    void addSubgenre(Genre genre) {
        subgenres.add(genre);
    }
}
