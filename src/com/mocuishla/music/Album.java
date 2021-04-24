package com.mocuishla.music;


import javax.sound.midi.SysexMessage;

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

    public int getYear() {
        return year;
    }

    public Artist getArtist() {
        return artist;
    }




}
