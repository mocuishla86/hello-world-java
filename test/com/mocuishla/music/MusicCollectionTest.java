package com.mocuishla.music;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MusicCollectionTest {

    @Test
    public void shouldBeCreated() {
        MusicCollection musicCollection = new MusicCollection();

        assertNotNull(musicCollection);
    }

    @Test
    public void shouldCountAlbums() {
        MusicCollection musicCollection = new MusicCollection();

        int numberOfAlbums = musicCollection.getNumberOfAlbums();

        assertEquals(0, numberOfAlbums);
    }


    @Test
    public void shouldAddAlbums() {
        MusicCollection musicCollection = new MusicCollection();
        Album album = new Album("Grandes Exitos", new Artist("Julio Iglesias"), 1996);

        musicCollection.addAlbum(album);
        int numberOfAlbums = musicCollection.getNumberOfAlbums();

        assertEquals(1, numberOfAlbums);
    }

    @Test
    public void shouldRemoveAlbums(){
        MusicCollection musicCollection = new MusicCollection();
       Album album = new Album("Grandes Exitos", new Artist("Shakira"), 2002);

        musicCollection.removeAlbum(album);
        int numberOfAlbums = musicCollection.getNumberOfAlbums();

        assertEquals(0, numberOfAlbums);
    }

    @Test
    public void shouldGetClassicAlbumsThatAreThoseEarlierThat1980() {
        MusicCollection musicCollection = new MusicCollection();
        musicCollection.addAlbum(new Album("Grandes Exitos", new Artist("Julio Iglesias"), 1996));
        musicCollection.addAlbum(new Album("Ziggy", new Artist("Bowie"), 1972));
        musicCollection.addAlbum(new Album("Grandes éxitos de Zenón", new Artist("Zenón Gonzáles"), 2010));
        musicCollection.addAlbum(new Album("Abbey Road", new Artist("Beatles"), 1969));
        musicCollection.addAlbum(new Album("Más", new Artist("Alejandro Sanz"), 1997));

        List<Album> oldies = musicCollection.getClassicalAlbums();

        assertEquals(2, oldies.size());
    }

    @Test
    public void shouldReturnAllTheArtistsFromMyCollection() {
        MusicCollection musicCollection = new MusicCollection();
        musicCollection.addAlbum(new Album("Grandes Exitos", new Artist("Julio Iglesias"), 1996));
        musicCollection.addAlbum(new Album("Ziggy", new Artist("Bowie"), 1972));
        musicCollection.addAlbum(new Album("Grandes éxitos de Zenón", new Artist("Zenón Gonzáles"), 2010));
        musicCollection.addAlbum(new Album("Abbey Road", new Artist("Beatles"), 1969));
        musicCollection.addAlbum(new Album("Más", new Artist("Alejandro Sanz"), 1997));

        List<String> artists = musicCollection.getAllArtists();

        assertEquals(List.of("Julio Iglesias", "Bowie", "Zenón Gonzáles", "Beatles", "Alejandro Sanz"), artists);
    }

    @Test
    public void shouldReturnTheOldestAlbum(){
        MusicCollection musicCollection = new MusicCollection();
        musicCollection.addAlbum(new Album("Grandes Exitos", new Artist("Julio Iglesias"), 1996));
        Album oldest = new Album("Ziggy", new Artist("Bowie"), 1972);
        musicCollection.addAlbum(oldest);

        Optional<Album> oldestAlbum = musicCollection.getOldest();

        assertTrue(oldestAlbum.isPresent());
        assertEquals(oldest, oldestAlbum.get());
    }

    @Test
    public void shouldReturnEmptyWhenNoAlbum(){
        MusicCollection musicCollection = new MusicCollection();

        Optional<Album> oldest = musicCollection.getOldest();

        assertTrue(oldest.isEmpty());
    }


}
