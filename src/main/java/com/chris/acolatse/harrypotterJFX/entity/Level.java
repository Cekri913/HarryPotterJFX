package com.chris.acolatse.harrypotterJFX.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Level {

    // Attributes
    private final int number;
    private final Enemy enemy;
    private String name;

    // Constructor
    public Level(int levelNumber, Enemy enemy, String levelDescription){
        this.number = levelNumber;
        this.enemy = enemy;
        this.name = levelDescription;
    }
    // Logic to start a level
    public String start(){
        String startMessage = "Welcome at the level " + this.number + " : " + this.name;
        System.out.println("Welcome at the level " + this.number + " : " + this.name);


        switch (this.number) {
            case 1, 2, 3, 5, 6 -> {
                System.out.println("You are meeting an enemy : " + enemy.getName()) ;
                startMessage.concat("You are meeting an enemy : " + enemy.getName());
            }
            case 4, 7 -> {
                System.out.println("You are meeting enemies : " + enemy.getName());
                startMessage.concat("You are meeting enemies : " + enemy.getName());
            }

        }
        System.out.println("The fight has begun ....");
        startMessage.concat("The fight has begun ....");
        System.out.println("startMessage : " + startMessage);
        String message = "Welcome at the level " + this.number + " : " + this.name
                + "\nYou are meeting an enemy : " + enemy.getName()
                + "\nThe fight has begun ....\n";
        System.out.println("message : " + message);
        return message;
    }

    public void start(String name) {
    }
}




