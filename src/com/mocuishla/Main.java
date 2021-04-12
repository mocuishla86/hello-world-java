package com.mocuishla;

import com.mocuishla.music.Album;
import com.mocuishla.music.Artist;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");

        Album album1 = new Album("Let It Be",new Artist("Beatles"), 1969);

        System.out.println(album1);

    }
}
