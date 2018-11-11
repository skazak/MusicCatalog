package ru.skazak;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {

    private static final Catalog catalog = Catalog.getInstance();

    public static void main(String[] args) {
        init();
        Finder finder = new Finder();
        System.out.println("Songs of Notorious : ");
        for (Song s : finder.findSongs(catalog.getArtists(), "Notorious b.i.g.", "", "", null, -1)) {
            System.out.println("Artist : " + s.getAlbum().getArtist().getTitle() + " Album: " + s.getAlbum().getTitle() + " Title: " + s.getTitle() + " Genre: " + s.getGenre().getTitle());
        }
        System.out.println("Songs of Notorious 1999 : ");
        for (Song s : finder.findSongs(catalog.getArtists(), "Notorious b.i.g.", "", "", null, 1999)) {
            System.out.println("Artist : " + s.getAlbum().getArtist().getTitle() + " Album: " + s.getAlbum().getTitle() + " Title: " + s.getTitle() + " Genre: " + s.getGenre().getTitle());
        }

        System.out.println("Songs of Notorious Rap: ");
        for (Song s : finder.findSongs(catalog.getArtists(), "Notorious b.i.g.", "", "", catalog.getGenre("Rap"), -1)) {
            System.out.println("Artist : " + s.getAlbum().getArtist().getTitle() + " Album: " + s.getAlbum().getTitle() + " Title: " + s.getTitle() + " Genre: " + s.getGenre().getTitle());
        }

        System.out.println("Songs of Notorious Gangsta Rap: ");
        for (Song s : finder.findSongs(catalog.getArtists(), "Notorious b.i.g.", "", "", catalog.getGenre("Gangsta Rap"), -1)) {
            System.out.println("Artist : " + s.getAlbum().getArtist().getTitle() + " Album: " + s.getAlbum().getTitle() + " Title: " + s.getTitle() + " Genre: " + s.getGenre().getTitle());
        }

        System.out.println("Song with title \"Lil Homies\" : ");
        for (Song s : finder.findSongs(catalog.getArtists(), "", "", "Lil Homies", null, -1)) {
            System.out.println("Artist : " + s.getAlbum().getArtist().getTitle() + " Album: " + s.getAlbum().getTitle() + " Title: " + s.getTitle() + " Genre: " + s.getGenre().getTitle());
        }

        System.out.println("Song from album \"Mas Fuerte\" : ");
        for (Song s : finder.findSongs(catalog.getArtists(), "", "Mas Fuerte", "", null, -1)) {
            System.out.println("Artist : " + s.getAlbum().getArtist().getTitle() + " Album: " + s.getAlbum().getTitle() + " Title: " + s.getTitle() + " Genre: " + s.getGenre().getTitle());
        }
    }

    private static void init() {
        Artist artist1 = new Artist("Notorious B.I.G.");

        Album album11 = new Album("Boys don't cry", artist1, 1999);
        album11.addSong(new Song("Gucci Gang", album11, catalog.getGenre("Hard Rock")));
        album11.addSong(new Song("D-Rose", album11, catalog.getGenre("Gangsta Rap")));
        artist1.addAlbum(album11);

        Album album12 = new Album("ASAP Forever", artist1, 1998);
        album12.addSong(new Song("Man", album12, catalog.getGenre("Rap")));
        album12.addSong(new Song("Praise the Lord", album12, catalog.getGenre("Hard Rock")));
        artist1.addAlbum(album12);
        catalog.addArtist(artist1);

        Artist artist2 = new Artist("2Pac");
        Album album21 = new Album("Mas Fuerte", artist2, 1998);
        album21.addSong(new Song("Lil Homies", album21, catalog.getGenre("Rap")));
        album21.addSong(new Song("Russian Most Wanted", album21, catalog.getGenre("Rock")));
        artist2.addAlbum(album21);
        catalog.addArtist(artist2);
    }


}
