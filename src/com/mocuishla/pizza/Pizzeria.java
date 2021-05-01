package com.mocuishla.pizza;

import java.util.List;
import java.util.Optional;

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

    public Optional<Pizza> cookMargherita() {

        if(tomato == 0 || mozzarella == 0){
            return Optional.empty();
        }
        tomato -= 1;
        mozzarella -=1;
        return Optional.of(new Pizza(List.of("tomato", "mozzarella")));
    }

    public Optional<Pizza> cookBianca() {
        if(ham == 0 || mozzarella == 0){
            return Optional.empty();
        }
        mozzarella -= 1;
        ham -= 1;
        return Optional.of(new Pizza(List.of("mozzarella", "ham")));
    }

    public Optional<Pizza> cookFormagio() {
        if(mozzarella < 2){
            return Optional.empty();
        }

        mozzarella -= 2;
        return Optional.of(new Pizza(List.of("mozzarella", "mozzarella")));
    }
}
