package com.mocuishla.pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pizza {

    private final List<String> ingredients;

    public Pizza(List<String> ingredients){
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString(){
    return "Pizza ingredients: " + ingredients;
    }
}
