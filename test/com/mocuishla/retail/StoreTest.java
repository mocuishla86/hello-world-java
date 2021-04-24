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



}
