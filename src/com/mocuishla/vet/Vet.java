package com.mocuishla.vet;

public class Vet {

    private String name;

    private int temperature;

    public Vet(String name) {
        this.name = name;
        this.temperature = 25;
    }

    public String getName() {
        return name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void openDoor() {
        if(temperature > 10) {
            temperature -= 3;
        }
    }
}
