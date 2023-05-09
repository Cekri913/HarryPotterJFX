package com.chris.acolatse.harrypotterJFX.entity;

public enum Pets {
    OWL, RAT, CAT, TOAD;

    public static boolean contains(String name){
        for (Pets pet: Pets.values()) {
            if(name.equals(pet.name()))
                return true;
        }
        return false;
    }
}
