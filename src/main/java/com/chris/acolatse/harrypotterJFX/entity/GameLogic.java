 package com.chris.acolatse.harrypotterJFX.entity;

import com.chris.acolatse.harrypotterJFX.utils.Constant;

import java.time.temporal.ValueRange;
import java.util.Scanner;

    public class GameLogic {

    private Wizard wizard;

    //Method to style the text et make it dynamic
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


    // This Constructor contains the whole game
    public GameLogic() {
        Scanner scanner = new Scanner(System.in);
        // Initialisation

        System.out.println(Constant.customDisplayText(Constant.FIVE_TAB, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", Constant.CYAN));
        System.out.println(Constant.customDisplayText(Constant.FIVE_TAB, "!!    HARRY POTTER AT HOME     !!", Constant.CYAN));
        System.out.println(Constant.customDisplayText(Constant.FIVE_TAB, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", Constant.CYAN));

        String welcomeText = """


                \t\tWelcome to Harry Potter at Home, the wizarding role-playing game.\s
                \t\tDo you have what it takes to become the greatest wizards ? \s
                \t\tYour goal is to complete your studies at Hogwarts.\s
                \t\tEach year will be filled with challenges.
                \t\tCan you meet all the challenges ?\s

                \t\tLet's get started!

                Now you’re a wizard, insert your nickname ...\s""";


        dispayWithDelay(welcomeText, 70);

        String name = scanner.nextLine();
        while(!isValidPseudo(name)){
            System.out.println(Constant.customDisplayText(Constant.ITALIC_TEXT,"Please put a capital letter and/or at least one number at your name"));
            name = scanner.nextLine();
        }  if(isValidPseudo(name)) {
            wizard = new Wizard(name);
            System.out.println(Constant.customDisplayText(Constant.BOLD_TEXT,"Welcome " + wizard.getName() + " !"));
        }

        choosePet();

        chooseCore();

        SortingHat sortingHat = new SortingHat();
        wizard.assignHouse(sortingHat);
        String randomHouse = name + ", The magic Choixpeau has just assigned to the House " + wizard.getHouse().name;

        dispayWithDelay(randomHouse, 70);


        // enemies

        Enemy troll = new Enemy("TROLL", 30);
        //List<Enemy> enemyList = new ArrayList<Enemy>();
        //enemyList.add(troll);
        // levels
        Level level1 = new Level(1, troll, "The Philosopher's stone");
        level1.start();
        fight(wizard, troll, level1);
        level1.end(wizard, troll);

        Enemy basilic = new Enemy("BASILIC", 45);
        Level level2 = new Level(2, basilic, "The Chamber of Secrets");
        level2.start();
        if(wizard.getHouse().name.equals(ListHouse.GRYFFINDOR.name())){
            System.out.println("You are from Gryffindor so you can use the legendary sword of Godric Gryffindor to take the basilic down.");
        }else {
            System.out.println("You are not from Gryffindor. You have to pull one of the fangs of the basilic out et use it to destroy the newspaper of Tom Jedusor.");
        }
        fight(wizard, basilic, level2);
        System.out.println("wizard : " + wizard.health);
        System.out.println("basilic : " + basilic.health);
        level2.end(wizard, basilic);

        Enemy detraqueurs = new Enemy("Les detraqueurs", 50);
        Level level3 = new Level(3, detraqueurs, "The Prisoner of Azkaban");
        level3.start();
        System.out.println("The Detractors are on the loose. They roam the streets, the countryside.");
        System.out.println("Hopefully, you've heard of a spell to put them to flight... Expect... Expecta... Ah yes, Expecto Patronum.");
        System.out.print("\n\n");
        System.out.println("Your goal is to learn the spell, then use it to defeat the Detractors.");
        wizard.learnSpell(new Spell("Expecto Patronum", 0, 1));
        fight(wizard, detraqueurs, level3);
        level3.end(wizard, detraqueurs);

        Enemy voldemort = new Enemy("Voldemort", 80);
        Enemy peterPettigrew = new Enemy("Peter Pettigrew", 60);
        Enemy duo1 = new Enemy("Peter Pettigrew et Voldemort",140 );
        Level level4 = new Level(4, duo1, "The Goblet of Fire");
        level4.start();
        String lvl4 = "Unfortunately, you have won the Three Wizards Tournament... and the right to die. You are in a graveyard, where Voldemort and Peter Pettigrew are also.\n Your only chance to escape is to get close to the Portkey and lure him to you (Accio!). \n Don't worry, you'll see Voldemort again...";
        dispayWithDelay(lvl4, 50);
        fight(wizard, duo1, level4);
        level4.end(wizard, duo1);

        Enemy doloresOmbrage = new Enemy("Dolores Ombrage", 70);
        Level level5 = new Level(5, doloresOmbrage, "The Order of the Phenix");
        level5.start();
        String lvl5 = "It's time for the BUSE (Universal Certificate of Elementary Witchcraft)! Dolores Umbridge is watching over the grain. \n Your goal is to distract her until the fireworks are ready to be used.";
        dispayWithDelay(lvl5, 50);
        fight(wizard, doloresOmbrage, level5);
        level5.end(wizard, doloresOmbrage);

        Enemy lesMangemorts = new Enemy("Les Mangemorts", 75);
        Level level6 = new Level(6, lesMangemorts, "The Half-Blood Prince");
        level6.start();
        String lvl6 = "The Death Eaters are attacking Hogwarts. Are you ready to defend yourself? You must attack them from the front (Sectumsempra).\n If you are from Slytherin, you may decide to join the Death Eaters.";
        dispayWithDelay(lvl6, 50);
        if(wizard.getHouse().name.equals(ListHouse.SLYTHERIN.name())){
            System.out.println("You are from Slytherin, you can join them !");
            System.out.println("You get directly to the next and last level.");
        }else{
            fight(wizard, lesMangemorts, level6);
            level6.end(wizard, lesMangemorts);
        }

        Enemy bellatrixLestrange = new Enemy("Bellatrix Lestrange", 80);
        Enemy duo2 =  new Enemy("Bellatrix Lestrange and Voldemort", 160);
        Level level7 = new Level(7, duo2, "The Deathly Hallows");
        level7.start();
        String lvl7 = "Let's stop stalling and get to the root of the problem. You are facing Voldemort and Bellatrix Lestrange.\n Be careful, they can kill you with Avada Kedavra if you are not ready.";
        dispayWithDelay(lvl7, 50);
        fight(wizard, duo2, level7);
        level7.end(wizard, duo2);

    }
    public static boolean isValidPseudo(String name) {
        boolean hasUppercase = !name.equals(name.toLowerCase());
        boolean hasDigit = name.matches(".*\\d.*");
        return hasUppercase && hasDigit;
    }

    // Method for the wizard to choose his pet
    public void choosePet() {
        System.out.println("Which pet do you want ? ");

        for (Pets pet : Pets.values()) {
            System.out.println(pet);
        }
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine().toUpperCase();

        while (!Pets.contains(answer)) {
            System.out.println("PLease choose a pet in the list.");
            answer = sc.nextLine().toUpperCase();
        }
        wizard.setPet(Pets.valueOf(answer));
        String choosePet = "Good choice, you chose the " + wizard.getPet() + ". This animal will follow you throughout your journey.";
        dispayWithDelay(choosePet, 50);
    }

        public void usePotion(Potion potion){
            if(wizard.getHouse().name.equals(ListHouse.HUFFLEPUFF.name())){
                System.out.println("You are  from Hufflepuff so potions are more effective on you.");
                potion.setEffectiveness((int) (potion.getEffectiveness() * 1.5));
                potion.drink(wizard);
            }
        }
        public void castSpell(Spell spell, Enemy enemy){
            if(wizard.getHouse().name.equals(ListHouse.SLYTHERIN.name())){
                System.out.println("You are from Slytherin so your spells are more powerfull.");
                spell.setDamage((int) (spell.getDamage() * 1.5));
            }spell.cast(enemy);
        }
        public void spellAccuracy(Spell spell, Enemy enemy){
            if(wizard.getHouse().name.equals(ListHouse.RAVENCLAW.name())){
                spell.setAccuracy(spell.getAccuracy() * 1.5);
            }
            spell.cast(enemy);
        }
// Methode for the wizard to choose the core of the wand
    public static Core chooseCore() {
        System.out.println("Please choose a core for your wand");
        final ValueRange range = ValueRange.of(1, Core.values().length);
        String answer;
        Core choice = null;

        for (Core core : Core.values()) {
            System.out.println(core.getCoreIndice() + " - " + core);
        }
        Scanner sc = new Scanner(System.in);
        answer = sc.nextLine();

        try {
            while (!range.isValidIntValue(Integer.parseInt(answer))) {
                System.out.println("Please choose a number between 1 and 4");
                answer = sc.nextLine();
            }
            for (Core c : Core.values()) {
                if (Integer.parseInt(answer) == c.getCoreIndice()) {
                    choice = c;
                }
            }
            System.out.println("You chose : " + choice.name());
            return choice;
        } catch (Exception e) {
            System.out.println(" Please choose a core in the list");
            return chooseCore();
        }
    }

    // Method for the mechanic of all the fight
    public static void fight(Wizard wizard, Enemy enemy, Level level) {
        Scanner scan = new Scanner(System.in);
        while(wizard.IsAlive() && enemy.IsAlive()) {
            System.out.println("Do you want to attack (1) or defend (2) ? : ");
            while (!scan.hasNextInt()) {
                scan.nextLine();
            }
            int choice = scan.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Please choose 1 or 2");
                scan.nextLine();
                choice = scan.nextInt();
            }
            if (choice == 1) {
                System.out.println("You choose to attack..");
                System.out.println("santé " + enemy.getName() + " : " + enemy.getHealth());
                System.out.println("santé wizard : " + wizard.getHealth());
                wizard.attack(enemy);
                System.out.println();
                enemy.attack(wizard, level);
                System.out.println();
            }
            if (choice == 2) {
                System.out.println();
                System.out.println("You choose to defend");
                wizard.defend(enemy, level);
                // force qui atténue la puissance de frappe de l'ennemy
            }
            System.out.println("santé " + enemy.getName()+ " : " + enemy.health);
            System.out.println("santé wizard : " + wizard.health);
        }if(!wizard.IsAlive()){
            System.out.println(Constant.customDisplayText(Constant.BLACK,wizard.getName() + ", " + enemy.getName() + " just killed you..."));
        } else if (!enemy.IsAlive()) {
            System.out.println(Constant.customDisplayText(Constant.GREEN,"Congratulation " + wizard.getName() + ", " + "you just killed " + enemy.getName()));

        }
    }

}



