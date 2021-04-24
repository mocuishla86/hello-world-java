package com.mocuishla;

import com.mocuishla.music.Album;
import com.mocuishla.music.Artist;
import com.mocuishla.retail.Store;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello world");
//
//        Album album1 = new Album("Let It Be",new Artist("Beatles"), 1969);
//
//        System.out.println(album1);

        Store store = new Store();

        Optional<Integer> cheapestPrice = store.getCheapestPriceForColor("gray");

        if(cheapestPrice.isPresent()) {
            final Integer price = cheapestPrice.get();
            System.out.println(price);
        } else {
            System.out.println("No shirts for this color");
        }

    }
}
