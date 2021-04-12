package com.mocuishla.music;


public class Album {

    private String name;

    private Artist artist;

    private int year;

    public Album(String name, Artist artist, int year) {
        this.name = name;
        this.artist = artist;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", author='" + artist + '\'' +
                '}';
    }
}
