package com.chris.acolatse.harrypotterJFX.entity;

import lombok.Getter;
import lombok.Setter;

public class Potion {
@Getter @Setter
    // Attributes
    private String name;

    public int getEffectiveness() {
        return effectiveness;
    }

    private int effectiveness;

    // Constructor
    public Potion(String name, int effectiveness) {
        this.name = name;
        this.effectiveness = effectiveness;
    }
    public void drink(Wizard wizard)  {
        // Logique pour boire la potion et regagner de la vie
        System.out.println("You are drinking the potion " + name  + "et you regain " + effectiveness + "of health.");
        wizard.setHealth(wizard.getHealth() + effectiveness);
    }
    public void setEffectiveness(int effectiveness){
        this.effectiveness = effectiveness;
    }


}
