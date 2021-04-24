package com.mocuishla.music;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Optional;

public class OptionalTest {

    @Test
    public void isEmpty_returns_true_if_it_is_empty()  {
        Optional<String> miOptional = Optional.empty();

        assertEquals(miOptional.isEmpty(), true);
    }

    @Test
    public void isPresent_returns_false_if_it_is_empty()  {
        Optional<String> miOptional = Optional.empty();

        assertEquals(miOptional.isPresent(), false);
    }

    @Test
    public void isPresent_returns_trye_if_it_is_present()  {
        Optional<String> miOptional = Optional.of("Paco");

        assertEquals(miOptional.isPresent(), true);
    }

    @Test
    public void sdsad() {
        String result = dimeAlgo(3);




        assertEquals(result.length(), 4);
    }




    private String dimeAlgo(int input) {
        if(input > 0) {
            return "Hola";
        } else {
            return null;
        }
    }

    private Optional<String> dimeAlgoMejorado(int input) {
        if(input > 0) {
            return Optional.of("Hola");
        } else {
            return Optional.empty();
        }
    }
}
