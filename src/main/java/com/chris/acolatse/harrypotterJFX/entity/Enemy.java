package com.chris.acolatse.harrypotterJFX.entity;

import com.chris.acolatse.harrypotterJFX.utils.Constant;
import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Random;
@Getter @Setter
public class Enemy {
    // Attributes
    @Getter @Setter
    public int id;

    @Getter @Setter
    public String name;
    public int damage;
    public int health;
    public Image avatar;

    public void updateEnemy() {
        switch (id){
            case 2:
                this.name="BASLIC";
                this.health=45;
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemy2.png")));
                break;
            case 3:
                this.name="LES DETRAQUEURS";
                this.health=50;
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemy3.png")));
                break;
            case 4:
                this.name="Peter PETTIGREW & VOLDEMORT";
                this.health=140;
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemy4.png")));
                break;
            case 5:
                this.name="Dolores Ombrage";
                this.health=70;
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/app_icon.png")));
                break;
            case 6:
                this.name="Les Mangemorts";
                this.health=75;
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/app_icon.png")));
                break;
            case 7:
                this.name="Bellatrix Lestrange and Voldemort";
                this.health=160;
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/app_icon.png")));
                break;
            case 1:
            default:
                this.name="TROLL";
                this.health=30;
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/enemy1.png")));
                break;
        }

    }


    // Constructor
    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public Enemy(int num) {
        this.id = num;
        updateEnemy();
    }

    // getters

    public String getName() {
        return this.name;
    }

    //Methodes
    public String attack(Wizard wizard, Level level ) {
        String message ="";
        if (!this.IsAlive()) {
            return message;
        } else{
            Random r = new Random();
            // We are generate a  random integer from 10 to 15
            damage = r.nextInt(10, 16);
            wizard.calculateDamage(damage);
            if(level.getNumber() == 4 ){
                damage *= 2;
                System.out.println("Petter Pettigrew and Voldemort has inflicted you "  + damage + " of damage.");
                message="Petter Pettigrew and Voldemort has inflicted you "  + damage + " of damage.";
            }
            if(level.getNumber() ==  7){
                damage *= 2.5;
                System.out.println("Bellatrix Lesange and Voldemort has inflicted you " + damage + " of damage.");
                message = "Bellatrix Lesange and Voldemort has inflicted you " + damage + " of damage.";
            }else {
                System.out.println(Constant.customDisplayText(Constant.RED, name + " has inflicted you " + damage + " of damage."));
                message = name +  " has inflicted you " + damage + " of damage.";
            }
        }
    return message;
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



