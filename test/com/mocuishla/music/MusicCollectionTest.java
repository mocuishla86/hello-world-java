package com.mocuishla.music;

import org.junit.jupiter.api.Test;

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
    public void shouldGetClassicAlbums() {
        MusicCollection musicCollection = new MusicCollection();
        Album album = new Album("Grandes Exitos", new Artist("Julio Iglesias"), 1996);

        musicCollection.addAlbum(album);
    }

}