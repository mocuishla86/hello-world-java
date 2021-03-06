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
    // 1. Add a new method to the store to add a new shirt to the Store.
    //    I will receive the shirt to be added as a parameter of the method
    @Test
    public void shouldAddShirtsToTheStore(){
        Store store = new Store();
        Shirt newShirt = new Shirt(30, "white");

        store.addNewShirt(newShirt);
        ArrayList<Shirt> numberOfTotalShirts = store.getAllShirts();

        assertEquals(5, numberOfTotalShirts.size());
    }

    @Test
    public void shouldGetTheCheapestOutfit(){
        Store store = new Store();

        Optional<Outfit> cheapestOutfit = store.getTheCheapestOutfit();

        assertEquals(20, cheapestOutfit.get().getShirt().getPrice());
        assertEquals("red", cheapestOutfit.get().getShirt().getColor());
        assertEquals(35, cheapestOutfit.get().getShoes().getSize());
        assertEquals("mocasines", cheapestOutfit.get().getShoes().getModel());
    }

    @Test
    public void shouldReturnEmptyOutfitWhenTheresAreNoShirtsOrShoes(){
        Store store = new Store(new ArrayList<Shirt>(), new ArrayList<Shoes>());

        Optional<Outfit> returnedOutfit = store.getTheCheapestOutfit();

        assertTrue(returnedOutfit.isEmpty());
    }

    @Test
    public void shouldReturnOutfitWithoutShoesWhenTheresAreNoShoesButThereAreShirts(){
        ArrayList<Shirt> shirts = new ArrayList<>();
        shirts.add(new Shirt(300, "red"));
        shirts.add(new Shirt(100, "blue"));
        Store store = new Store(shirts, new ArrayList<Shoes>());

        Optional<Outfit> returnedOutfit = store.getTheCheapestOutfit();

        assertEquals(100, returnedOutfit.get().getShirt().getPrice());
        assertEquals("blue", returnedOutfit.get().getShirt().getColor());
        assertNull(returnedOutfit.get().getShoes());
    }

    @Test
    public void ShouldReturnOutfitWithTheMostExpensiveShirtAndTheBiggestShoes(){
        Store store = new Store();

        Optional<Outfit> returnedOutfit = store.getExtravagantOutfit();

        assertEquals(200, returnedOutfit.get().getShirt().getPrice());
        assertEquals("blue", returnedOutfit.get().getShirt().getColor());
        assertEquals("heels", returnedOutfit.get().getShoes().getModel());
        assertEquals(39, returnedOutfit.get().getShoes().getSize());
    }

    @Test
    public void shouldReturnEmptyWhenTheresNoShoesButTheresShirt(){
        ArrayList<Shirt> shirts = new ArrayList<>();
        shirts.add(new Shirt(300, "blue"));
        shirts.add(new Shirt(200, "green"));

        Store store = new Store(shirts, new ArrayList<Shoes>());

        Optional<Outfit> returnedOutfit = store.getExtravagantOutfit();

        assertTrue(returnedOutfit.isEmpty());
    }

    @Test
    public void returnOutfitWithTheBiggestShoesWhenTheresShoesButNotShirt(){
        ArrayList<Shoes> shoes = new ArrayList<>();
        shoes.add(new Shoes("babuchas", 45));
        shoes.add(new Shoes("tacones", 35));

        Store store = new Store(new ArrayList<Shirt>(), shoes);

        Optional<Outfit> returnedOutfit = store.getExtravagantOutfit();

        assertEquals("babuchas", returnedOutfit.get().getShoes().getModel());
        assertEquals(45, returnedOutfit.get().getShoes().getSize());
        assertNull(returnedOutfit.get().getShirt());
    }


    //OUTFIT: Nuevo concepto.
    // 2. Crea una clase llamada Outfit. Un outfit est?? representada por una Shirt y un par de zapatos (1 shoes).
    //3. Crea un m??todo llamaado GetCheapestOutfit que te devuelve un Outfit
    // (mejor dicho, un Optional de empty) conteniendo la camisa y los zapatos m??s baratos de la tienda.
      //Si no hay zapatos o camisa, devuelve un Optional.Empty
    //4. Crea un m??todo llamaado GetExtravagantOutfit que te devuelve un Outfit conteniendo la camisa m??s cara
    // y los zapatos m??s grandes.
    // Si no hay zapatos pero s?? hay camisa  devuelve un Optional.Empty
    // Si no hay camisa pero s?? hay zapatos  devuelve un Optional
    // con los zapatos m??s grandes y sin camisa (es decir, null)
}
