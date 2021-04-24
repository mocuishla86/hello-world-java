package com.mocuishla.retail;

import java.util.ArrayList;
import java.util.Optional;

public class Store {
    private ArrayList<Shirt> shirts;

    public Store() {
        shirts = new ArrayList<Shirt>();
        shirts.add(new Shirt(100, "green"));
        shirts.add(new Shirt(200, "blue"));
        shirts.add(new Shirt(50, "green"));
        shirts.add(new Shirt(20, "red"));

    }

    public ArrayList<Shirt> getAllShirts() {
        return shirts;
    }

    public Optional<Integer> getCheapestPriceForColor(String color) {
        return shirts.stream()
            .filter(shirt -> shirt.getColor().equals(color))
            .map(shirt -> shirt.getPrice())
            .min((integer, anotherInteger) -> integer.compareTo(anotherInteger));
    }
}
