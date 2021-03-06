package com.mocuishla.retail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Store {
    private ArrayList<Shirt> shirts;

    private ArrayList<Shoes> shoes;

    private ArrayList<Outfit> outfit;

    public Store() {
        shirts = new ArrayList<Shirt>();
        shirts.add(new Shirt(100, "green"));
        shirts.add(new Shirt(200, "blue"));
        shirts.add(new Shirt(50, "green"));
        shirts.add(new Shirt(20, "red"));

        shoes = new ArrayList<Shoes>();
        shoes.add(new Shoes("heels", 39));
        shoes.add(new Shoes("mocasines", 35));

        outfit = new ArrayList<Outfit>();
    }

    public Store(ArrayList<Shoes> shoes) {
        this.shoes = shoes;
    }


    public Store(ArrayList<Shirt> shirts, ArrayList<Shoes> shoes) {
        this.shirts = shirts;
        this.shoes = shoes;
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

    public Optional<String> getTheMostExpensiveShirtColor() {

        return shirts.stream().max(Comparator.comparing(Shirt::getPrice)).map(Shirt::getColor);
    }

    public ArrayList<Shoes> getShoes() {

        return shoes;
    }

    public int getNumberOfItems() {
        int numberOfShirts = shirts.size();
        int numberOfShoes = shoes.size();
        return numberOfShirts + numberOfShoes;
    }


    public void addNewShirt(Shirt newShirt) {
        shirts.add(newShirt);
    }

    public Optional<Outfit> getTheCheapestOutfit() {
        if (shirts.isEmpty()) {
            return Optional.empty();
        }
        if (shoes.isEmpty()) {
            Shirt cheapestShirt = shirts.stream().min(Comparator.comparing(Shirt::getPrice)).get();
            return Optional.of(new Outfit(cheapestShirt, null));
        }

        Shirt cheapestShirt = shirts.stream().min(Comparator.comparing(Shirt::getPrice)).get();
        Shoes cheapestShoe = shoes.stream().min(Comparator.comparing(Shoes::getSize)).get();
        return Optional.of(new Outfit(cheapestShirt, cheapestShoe));
    }

    public Optional<Outfit> getExtravagantOutfit() {
        if(shoes.isEmpty()){
            return Optional.empty();
        }
        if(shirts.isEmpty()){
            Shoes biggestShoesSize = shoes.stream().max(Comparator.comparing(Shoes::getSize)).get();
            return Optional.of(new Outfit(null, biggestShoesSize));
        }

        Shirt mostExpensiveShirt = shirts.stream().max(Comparator.comparing(Shirt::getPrice)).get();
        Shoes biggestShoesSize = shoes.stream().max(Comparator.comparing(Shoes::getSize)).get();
        Optional<Outfit> extravagantOutfit = Optional.of(new Outfit(mostExpensiveShirt, biggestShoesSize));
        return extravagantOutfit;
    }
}
