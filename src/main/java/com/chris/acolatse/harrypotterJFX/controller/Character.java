package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Wizard;

public class Character{
    String name;
    String animal;
    String core;
    Wizard wizard;
    String house;
    public Character(String name, String animal, String core) {
        this.name = name;
        this.animal = animal;
        this.core = core;
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



   /* @Override
    public String toString() {
        return "Name: " + wizard.getName + "\nPet: " + wizard.getPet + "\nCore: " + wizard.getCore;
    }

    */


}