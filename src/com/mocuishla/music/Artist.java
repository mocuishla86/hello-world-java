package com.mocuishla.music;

public class Artist {

    private String name;

    public Artist(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                '}';
    }
}
