package com.chris.acolatse.harrypotterJFX.entity;

import com.chris.acolatse.harrypotterJFX.utils.Constant;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
@Getter @Setter
public class Level {

    // Attributes
    private final int number;
    private final Enemy enemy;
    private String name;

    // Constructor
    public Level(int argNumber, Enemy enemy, String argName){
        this.number = argNumber;
        this.enemy = enemy;
        this.name = argName;
    }
    // Logic to start a level
    public void start(){
        System.out.println("Welcome at the level " + this.number + " : " + this.name);

        switch (this.number) {
            case 1, 2, 3, 5, 6 -> System.out.println("You are meeting an enemy : " + enemy.getName());
            case 4, 7 -> System.out.println("You are meeting enemies : " + enemy.getName());

        }
        System.out.println("The fight has begun ....");
    }

    public void end(Wizard wizard, Enemy enemy) {
        Scanner sc = new Scanner(System.in);
        if (!enemy.IsAlive()) {
            System.out.println("You just finished the level " + this.name);
            if(this.number == 7){
                System.out.println("Congratulations " + wizard.getName() + ", you passed all the 7 levels. \n You are now graduated of the most prestigious witchcraft school on the planet ");
                System.out.println("Do you want to start again ? \n 1- Yes \n 2- No");
                String start = sc.nextLine().toUpperCase();
                while(!start.equals("Yes".toUpperCase()) && !start.equals("No".toUpperCase())){
                    System.out.println("Please choose yes or no");
                    sc.nextLine();
                }
                if(start.equals("Yes".toUpperCase())){
                    System.out.println("Let's restart !");
                    GameLogic gamelogic = new GameLogic();
                }else{
                    System.out.println("See you soon !");
                }

            }else {
                System.out.println("Do you want increase your health (1) or increase your spellDamage (2) for the next of your journey ? ");
                while (!sc.hasNextInt()) {
                    System.out.println("Please choose 1 or 2");
                    sc.nextLine();
                }
                int choice = sc.nextInt();
                while (choice != 1 && choice != 2) {
                    System.out.println("Please choose 1 or 2");
                    sc.nextLine();
                    choice = sc.nextInt();
                }

                if (choice == 1) {
                    System.out.println("health increasing...");
                    double amount = (Math.random()) * 2 + 1;
                    wizard.increaseHealth(amount);
                    System.out.println("Increasing success !\n Your health has been increased, your health now is " + wizard.getHealth());
                }
                if (choice == 2) {
                    System.out.println("damage increasing...");
                    double amount = (Math.random() * 2 + 1);
                    wizard.increaseDamage(amount);
                    System.out.println("Increasing success !\n Your spellDamage has been multiplied by " + amount);
                    System.out.println(Wizard.getSpellAmplitude());
                }
            }
            } else if (!wizard.IsAlive()) {
                System.out.println(Constant.customDisplayText(Constant.FIVE_TAB, "GAME OVER", Constant.RED));
                GameLogic gameLogic2 = new GameLogic();
        }
    }
}




