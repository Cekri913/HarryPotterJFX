package com.chris.acolatse.harrypotterJFX.entity;

public class Character{
    String name;
    String animal;
    String core;
    String house;
    public Character(String name, String animal, String core, String house) {
        this.name = name;
        this.animal = animal;
        this.core = core;
        this.house = house;
    }
    public String getName() {
        return name;
    }

    public String getAnimal() {
        return animal;
    }

    public String getCore() {
        return core;
    }

    public String getHouse() {
        return house;
    }

    @Override
    public String toString() {
        return "Nom: " + name + "\nAnimal: " + animal + "\nCœur: " + core + "\nMaison: " + house;
    }


}