package com.mocuishla.pizza;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.io.PipedInputStream;
import java.util.List;
import java.util.Optional;

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

        Optional<Pizza> margherita = pizzeria.cookMargherita();
        List<String> margheritaIngredients = margherita.get().getIngredients();

        assertEquals(List.of("tomato", "mozzarella"), margheritaIngredients);
        assertEquals(0, pizzeria.getMozzarella());
        assertEquals(0, pizzeria.getTomato());

    }

    @Test
    public void shouldReturnEmptyOfPizzaMargheritaIfTheresNoTomatoOrMozzarella(){
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.buyMozzarella();

        Optional<Pizza> margherita = pizzeria.cookMargherita();
        int mozzarella = pizzeria.getMozzarella();

        assertTrue(margherita.isEmpty());
        assertEquals(1, mozzarella);
    }

    @Test
    public void shouldCookPizzaWithAServeOfMozzarellaAndAServeOfHam(){
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.buyMozzarella();
        pizzeria.buyHam();

        Optional<Pizza> biancaYork = pizzeria.cookBianca();
        List<String> biancaIngredients = biancaYork.get().getIngredients();

        assertEquals(List.of("mozzarella", "ham"), biancaIngredients);
    }

    @Test
    public void shouldReturnEmptyOfPizzaBiancaIfTheresNoHamOrMozzarella(){
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.buyMozzarella();

        Optional<Pizza> biancaYork = pizzeria.cookBianca();
        int mozzarella = pizzeria.getMozzarella();

        assertEquals(1,mozzarella);
        assertTrue(biancaYork.isEmpty());
    }

    @Test
    public void shouldCookPizzaWithTwoServesOfMozzarella(){
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.buyMozzarella();
        pizzeria.buyMozzarella();

        Optional<Pizza> formaggio = pizzeria.cookFormagio();
        List<String> formaggioIngredients = formaggio.get().getIngredients();

       assertEquals(List.of("mozzarella", "mozzarella"), formaggioIngredients);

    }

    @Test
    public void shouldReturnEmptyWhenTheresOnlyAServeOfMozzarella(){
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.buyMozzarella();

        Optional<Pizza> formaggio = pizzeria.cookFormagio();
        int mozzarella = pizzeria.getMozzarella();

        assertTrue(formaggio.isEmpty());
        assertEquals(1, mozzarella);
    }

    @Test
    public void shouldReturnEmptyWhenTheresNoIngredients(){
        Pizzeria pizzeria = new Pizzeria();

        Optional<Pizza> formaggio = pizzeria.cookFormagio();
        int mozzarella = pizzeria.getMozzarella();

        assertTrue(formaggio.isEmpty());
        assertEquals(0, mozzarella);

    }
}