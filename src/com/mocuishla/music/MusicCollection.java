package com.mocuishla.music;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MusicCollection {
    private ArrayList<Album> albums = new ArrayList<>();

    public int getNumberOfAlbums() {
        return albums.size();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public List<Album> getClassicalAlbums() {
        return albums.stream().filter(album -> album.getYear() < 1980).collect(Collectors.toList());
    }

    public List<String> getAllArtists() {
        return albums.stream().map(album -> album.getArtist()).map(artist -> artist.getName()).collect(Collectors.toList());
    }
}
