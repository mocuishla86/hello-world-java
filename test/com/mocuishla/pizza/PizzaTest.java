package com.mocuishla.pizza;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaTest {
    @Test
    public void shouldBeCreatedFromAListOfIngredients(){
        Pizza pizza = new Pizza(List.of("tomato", "mozzarella", "ham"));

        List<String> actualIngredients = pizza.getIngredients();

        assertEquals(3, actualIngredients.size());

    }

    @Test
    public void shouldBePrinted(){
        Pizza pizza = new Pizza(List.of("tomato", "mozzarella", "ham"));

        String pizzaStr = pizza.toString();

        assertEquals("Pizza ingredients: [tomato, mozzarella, ham]", pizzaStr);

    }
}