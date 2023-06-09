package com.chris.acolatse.harrypotterJFX.entity;
import com.chris.acolatse.harrypotterJFX.utils.Constant;
import javafx.scene.image.Image;
import lombok.Data;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


//attributs du personnage
@Data @Getter
public class Wizard {
    private String name;

    private Image avatar;
    public int health;
    private boolean inDefense;
    private Pets pet;
    private Core core;
    public House house;
    public static int spellAmplitude = 15;
    private List<Spell> spells;

    public void updateAvatar() {
        switch (pet){
            case CAT:
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/cat.png")));
                break;
            case TOAD:
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/cat.png")));
                break;
            case RAT:
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/cat.png")));
                break;
            case OWL:
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/cat.png")));
                break;
            default:
                this.avatar= new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/versus_icon.png")));
                break;
        }

    }

    // Constructor
    public Wizard(String name) { //, int health, Pets pet, Wand wand, House house) {
        this.name = name;
        this.health = 100;
        this.house  = new House(SortingHat.assignHouse());
        this.inDefense = false;
        spells = new ArrayList<>();
    }
    // getters

    public int getHealth() {
        return health;
    }
    public static int getSpellAmplitude() {
        return spellAmplitude;
    }

    //setters

    public void setPet(Pets pet) {
        this.pet = pet;
        updateAvatar();
    }
    public boolean IsAlive(){
        return this.health > 0;
    }
    public void increaseHealth(double amount) {
        this.health *= amount;
    }
    public void increaseDamage(double amount) {
        spellAmplitude *= amount;
    }
    public void assignHouse(SortingHat sortingHat) {
        this.house = house;
        System.out.println("Your house is " + house);
    }
    // Methodes
    public void calculateDamage(int damage) {
        if (inDefense) {
            // Réduire les dégâts d'un certain coefficient si le joueur est en défense
            Random rand = new Random();
            int coef = rand.nextInt(1,4);
            damage = damage / coef;
        }
        health -= damage;
        this.takeDamage(damage);
    }
    public static void dispayWithDelay(String input,long delay){
        for (int i=0; i< input.length(); i++){
            System.out.print(input.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("\n\n");
    }
    public void learnSpell(Spell spell){
        spells.add(spell);
        String spellLearning = "You are practising the spell in order to learn it...";
        dispayWithDelay(spellLearning, 60);
        System.out.println("You learned the spell " + spell.getName() + ".");
    }
    public void takeDamage(int damage){
        if(this.getHouse().name.equals(ListHouse.GRYFFINDOR.name())){
            System.out.println("You are from Gryffindor so you are more resistant to enemys' attacks.");
            damage = (int) (damage * 0.8);
        }
        this.setHealth(this.getHealth() - damage);
    }
   public String attack(Enemy enemy) {
       String message =null;
        this.inDefense = false;
       Random r = new Random();
       int damage = r.nextInt(16);
       if (damage == 0) {
           System.out.println("You missed your spell...");
           message="You missed your spell...";
       } else {
           enemy.calculateDamage(damage);
           System.out.println(Constant.customDisplayText(Constant.BOLD_TEXT,"You have inflicted " + damage + " of damages to " + enemy.getName(), Constant.GREEN));
           message="You have inflicted " + damage + " of damages to " + enemy.getName();
       }
       return message;
   }

    public String defend(Enemy enemy, Level level) {
        this.inDefense = true;
        enemy.attack(this, level);
        String message = "Your are in mode DEFENSE";
        return message;
    }

}



