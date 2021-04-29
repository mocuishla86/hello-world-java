package com.mocuishla.pizza;

import java.util.List;

public class Pizzeria {

    private int tomato;
    private int mozzarella;
    private int ham;



    public Pizzeria(){
        this.tomato = tomato;
        this.mozzarella = mozzarella;
        this.ham = ham;

    }

    public int getTomato() {
        return tomato;
    }

    public int getMozzarella() {
        return mozzarella;
    }

    public int getHam() {
        return ham;
    }

    public void buyTomato() {
        tomato = tomato + 1;
    }

    public void buyMozzarella() {
        mozzarella += 1;
    }

    public void buyHam() {
        ham += 1;
    }

    public Pizza cookMargherita() {
        tomato -= 1;
        mozzarella -=1;
        return new Pizza(List.of("tomato", "mozzarella"));
    }
}
