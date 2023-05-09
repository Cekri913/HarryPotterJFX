package com.chris.acolatse.harrypotterJFX.entity;

import com.chris.acolatse.harrypotterJFX.utils.Constant;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter @Setter
public class Enemy {
    // Attributes
    public String name;
    public int damage;
    public int health;


    // Constructor
    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // getters

    public String getName() {
        return this.name;
    }

    //Methodes
    public void attack(Wizard wizard, Level level ) {
        if (!this.IsAlive()) {
            return;
        } else{
            Random r = new Random();
            // We are generate a  random integer from 10 to 15
            damage = r.nextInt(10, 16);
            wizard.calculateDamage(damage);
            if(level.getNumber() == 4 ){
                damage *= 2;
                System.out.println("Petter Pettigrew and Voldemort has inflicted you "  + damage + " of damage.");
            }
            if(level.getNumber() ==  7){
                damage *= 2.5;
                System.out.println("Bellatrix Lesange and Voldemort has inflicted you " + damage + " of damage.");
            }else {
                System.out.println(Constant.customDisplayText(Constant.RED, name + " has inflicted you " + damage + " of damage."));
            }
        }

    }
    // The Method calculateDamage allow us to take damage made by the wizard
    public void calculateDamage(int damage) {
        this.health -= damage;
    }
    // The method isAlive verify if the  enemy is alive or not at anytime in the game
    public boolean IsAlive(){
        return this.health > 0;
    }

}



