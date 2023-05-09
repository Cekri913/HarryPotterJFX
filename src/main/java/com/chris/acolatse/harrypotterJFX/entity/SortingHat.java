package com.chris.acolatse.harrypotterJFX.entity;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingHat {
    // Available House List

    // we transform a list of values (public enum ListHouse) in a string list
    // we stream l'enum, we turn it in a list, on run the list then we make it a collection
    public static final List<String> HOUSES = Stream.of((ListHouse.values())).map(ListHouse::name).collect(Collectors.toList());

    // Methode allow to the magic Choixpeau to assign a house to a wizard by choosing randomly among the available houses.

    public static String assignHouse(){
        Random r = new Random();
        int min = 0;
        int max = HOUSES.size() - 1;
        int random = r.nextInt((max - min) + 1) + min;

        String chosenHousename = HOUSES.get(random);
        return chosenHousename;

    }
}
