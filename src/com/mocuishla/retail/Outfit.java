package com.mocuishla.retail;

public class Outfit {

    private Shirt shirt;

    private Shoes shoes;

    public Outfit(Shirt shirt, Shoes shoes){
        this.shirt = shirt;
        this.shoes = shoes;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public Shoes getShoes() {
        return shoes;
    }
}
