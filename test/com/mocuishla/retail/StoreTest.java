package com.mocuishla.retail;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    @Test
    public void shouldHave4ShirtsAtConstruction() {
        Store store = new Store();

        ArrayList<Shirt> shirts = store.getAllShirts();

        assertEquals(4, shirts.size());
    }

    @Test
    public void shouldProvideCheapestPriceForAGivenColor() {
        Store store = new Store();

        Optional<Integer> cheapestPrice = store.getCheapestPriceForColor("green");
        final Integer integer = cheapestPrice.get();

        assertEquals(50, integer);
    }

    @Test
    public void shouldProvide0ForUnexistingColors() {
        Store store = new Store();

        Optional<Integer>  cheapestPrice = store.getCheapestPriceForColor("gray");

        assertTrue(cheapestPrice.isEmpty());
    }

    @Test
    public void shouldProvideColorOfTheMostExpensiveShirt(){
        Store store = new Store();

        Optional<String> mostExpensiveColor = store.getTheMostExpensiveShirtColor();

        assertTrue(mostExpensiveColor.isPresent());
        assertEquals("blue", mostExpensiveColor.get());
    }

    @Test
    public void shouldHave2ShoesAtConstruction(){
        Store store = new Store();

        ArrayList<Shoes> shoes = store.getShoes();

        assertEquals(2, shoes.size());
    }

    @Test
    public void shouldBeCreatedFromShoes(){
        ArrayList<Shoes> myShoes = new ArrayList<Shoes>();
        myShoes.add(new Shoes("heels", 36));

        Store store = new Store(myShoes);

        assertEquals(1,store.getShoes().size());
        assertNull(store.getAllShirts());
    }

    @Test
    public void shouldBeCreatedFromShirtsAndShoes(){
        ArrayList<Shirt> myShirts = new ArrayList<Shirt>();
        myShirts.add(new Shirt(30, "orange"));
        myShirts.add(new Shirt(25, "pink"));

        ArrayList<Shoes> myShoes = new ArrayList<Shoes>();
        myShoes.add(new Shoes("traineers", 37));

        Store store = new Store(myShirts, myShoes);

        assertEquals(2, store.getAllShirts().size());
        assertEquals(1, store.getShoes().size());
    }

    @Test
    public void shouldReturnTheTotalNumberOfItems() {
        Store store = new Store();

        int numberOfItems = store.getNumberOfItems();

        assertEquals(6, numberOfItems);

    }
}
