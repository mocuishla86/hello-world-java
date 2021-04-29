package com.mocuishla.pizza;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PizzeriaTest {

    @Test
    public void shouldHaveThreeKindsOfIngredientsButZeroAtConstruction(){
        Pizzeria pizzeria = new Pizzeria();

        int tomato = pizzeria.getTomato();
        int mozzarella = pizzeria.getMozzarella();
        int ham = pizzeria.getHam();

        assertEquals(0, tomato);
        assertEquals(0, mozzarella);
        assertEquals(0, ham);
    }

    @Test
    public void shouldBuyTomatoIngredient(){
        Pizzeria pizzeria = new Pizzeria();

        pizzeria.buyTomato();
        int tomato = pizzeria.getTomato();

        assertEquals(1, tomato);
    }

    @Test
    public void shouldBuyMozzarellaIngredient(){
        Pizzeria pizzeria = new Pizzeria();

        pizzeria.buyMozzarella();
        int mozzarella = pizzeria.getMozzarella();

        assertEquals(1, mozzarella);
    }

    @Test
    public void shouldBuyHamIngredient(){
        Pizzeria pizzeria = new Pizzeria();

        pizzeria.buyHam();
        int ham = pizzeria.getHam();

        assertEquals(1, ham);
    }

    @Test
    public void shouldCookAPizzaWithAServeOfTomatoAndAServeOfMozzarella(){
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.buyMozzarella();
        pizzeria.buyTomato();

        Pizza margherita = pizzeria.cookMargherita();
        List<String> margheritaIngredients = margherita.getIngredients();

        assertEquals(List.of("tomato", "mozzarella"), margheritaIngredients);
        assertEquals(0, pizzeria.getMozzarella());
        assertEquals(0, pizzeria.getTomato());

    }
}