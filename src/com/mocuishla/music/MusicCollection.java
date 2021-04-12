package com.mocuishla.music;

import java.util.ArrayList;

public class MusicCollection {
    private ArrayList<Album> albums = new ArrayList<>();

    public int getNumberOfAlbums() {
        return albums.size();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
}
