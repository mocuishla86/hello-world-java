package com.mocuishla.vet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VetTest {

    @Test
    public void shouldHaveACustomisableName() {
        Vet vet = new Vet("Clínicas Maruja");

        String name = vet.getName();

        assertEquals("Clínicas Maruja", name);
    }

    @Test
    public void whenCreatedItHas25Degrees() {
        Vet vet = new Vet("Clínicas Maruja");

        int temperature = vet.getTemperature();

        assertEquals(25, temperature);
    }

    @Test
    public void whenWeOpenTheDoorThenTheTemperatureDecreasesInThreeDegrees() {
        Vet vet = new Vet("Clínicas Maruja");

        vet.openDoor();
        int temperature = vet.getTemperature();

        assertEquals(22, temperature);
    }

    @Test
    public void whenWeOpenTheDoorAndTheTemperatureIsLowerThan10ThenTheTemperatureDoesNOTChange() {
        Vet vet = new Vet("Clínicas Maruja");

        vet.openDoor();
        vet.openDoor();
        vet.openDoor();
        vet.openDoor();
        vet.openDoor();
        vet.openDoor();
        int temperature = vet.getTemperature();

        assertEquals(10, temperature);
    }

}
