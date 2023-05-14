package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.HarryPotterJfxApp;
import com.chris.acolatse.harrypotterJFX.entity.*;
import com.chris.acolatse.harrypotterJFX.utils.Constant;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GameController implements Initializable {

    EntityHolder holder;

    Button attackButton;
    Button defendButton;
    Label figthInfo;

    String gameMessage;

    public void quit(ActionEvent event){
        Platform.exit();
    }

    public void attack() {
        Enemy enemy = holder.getCurrentLevel().getEnemy();
        Wizard wizard = holder.getWizard();
        Level level = holder.getCurrentLevel();
        attackButton = (Button) holder.getGameRoot().lookup("#attack");
        defendButton = (Button) holder.getGameRoot().lookup("#defend");
        figthInfo = (Label) holder.getGameRoot().lookup("#fightLabel");
        Button quitGame = (Button) holder.getGameRoot().lookup("#quitGame");
        Button continueGame = (Button) holder.getGameRoot().lookup("#continueGame");
        Button restartGame = (Button) holder.getGameRoot().lookup("#restartGame");
        HBox playButtons = (HBox) holder.getGameRoot().lookup("#playButtons");

        Label wHealth = (Label) holder.getGameRoot().lookup("#wHealth");
        Label eHealth = (Label) holder.getGameRoot().lookup("#eHealth");

        continueGame.setVisible(false);
        restartGame.setVisible(false);
        playButtons.setVisible(true);
        quitGame.setVisible(true);
        playButtons.setVisible(true);



        if (wizard.IsAlive() && enemy.IsAlive()) {
            System.out.println("You choose to attack..");
            System.out.println("santé " + enemy.getName() + " : " + enemy.getHealth());
            System.out.println("santé wizard : " + wizard.getHealth());
            gameMessage = wizard.attack(enemy);
            System.out.println();

            String enemyMessage = enemy.attack(wizard, level);
            System.out.println("gameMessage : " + gameMessage);
            System.out.println("enemyMessage : " + enemyMessage);
            gameMessage = gameMessage.concat("   --- " +
                    "  " + enemyMessage);
            System.out.println("gameMessage2 : " + gameMessage);
            System.out.println();

            System.out.println("santé " + enemy.getName() + " : " + enemy.health);
            System.out.println("santé wizard : " + wizard.health);

            wHealth.setText("Health : " +holder.getWizard().health);
            eHealth.setText("Health : " +holder.getCurrentLevel().getEnemy().health);

            figthInfo.setText(gameMessage);

        }
        if (!wizard.IsAlive()) {
            System.out.println(Constant.customDisplayText(Constant.YELLOW, wizard.getName() + ", " + enemy.getName() + " just killed you..."));
            System.out.println(Constant.customDisplayText(Constant.RED, wizard.getName() + ", " + enemy.getName() + " GAME OVER !!! "));
            gameMessage = wizard.getName() + ", " + enemy.getName() + " just killed you..."
                          + "\n Continue or exit game ? \n\n\n";
            figthInfo.setText(gameMessage);
            figthInfo.setTextFill(Color.RED);
            wHealth.setTextFill(Color.RED);
            continueGame.setVisible(false);
            restartGame.setVisible(true);
            playButtons.setVisible(false);
        } else if (!enemy.IsAlive()) {
            gameMessage = "Congratulation " + wizard.getName() + ", " + "you just killed " + enemy.getName()
                        + "\n Continue or exit game ? \n";
            System.out.println(Constant.customDisplayText(Constant.GREEN, "Congratulation " + wizard.getName() + ", " + "you just killed " + enemy.getName()));
            figthInfo.setText(gameMessage);
            figthInfo.setTextFill(Color.GREEN);
            eHealth.setTextFill(Color.RED);
            playButtons.setVisible(false);
            continueGame.setVisible(true);
            restartGame.setVisible(true);
        }

    }

    public void defend2() {
       /* holder = EntityHolder.getInstance();
        Enemy enemy = holder.getCurrentLevel().getEnemy();
        Wizard wizard = holder.getWizard();
        Level level = holder.getCurrentLevel();
        //level.start();
        figthInfo.setText(holder.getCurrentLevel().start());

        if (wizard.IsAlive() && enemy.IsAlive()) {

            System.out.println();
            System.out.println("You choose to defend");
            wizard.defend(enemy, level);
            // force qui atténue la puissance de frappe de l'ennemy

            System.out.println("santé " + enemy.getName() + " : " + enemy.health);
            System.out.println("santé wizard : " + wizard.health);

        }
        if (!wizard.IsAlive()) {
            System.out.println(Constant.customDisplayText(Constant.BLACK, wizard.getName() + ", " + enemy.getName() + " just killed you..."));
        } else if (!enemy.IsAlive()) {
            System.out.println(Constant.customDisplayText(Constant.GREEN, "Congratulation " + wizard.getName() + ", " + "you just killed " + enemy.getName()));

        }

        end();*/
    }



    public void end() {
       // Scanner sc = new Scanner(System.in);
        Enemy enemy = holder.getCurrentLevel().getEnemy();
        Wizard wizard = holder.getWizard();
        Level level = holder.getCurrentLevel();

       /* if (!enemy.IsAlive()) {
            System.out.println("You just finished the level " + level.getName());
            if(level.getNumber() == 7){
                System.out.println("Congratulations " + wizard.getName() + ", you passed all the 7 levels. \n You are now graduated of the most prestigious witchcraft school on the planet ");
                System.out.println("Do you want to start again ? \n 1- Yes \n 2- No");
               // String start = sc.nextLine().toUpperCase();
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
        }*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        holder = EntityHolder.getInstance();
        //lunchParty();
    }

    public void continueGame(ActionEvent event) throws IOException {

        if (holder.getLevelId()<7) {
            holder.setLevelId(holder.getLevelId() + 1);
            holder.setCurrentLevel();

        holder.setCurrentLevel();
        Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml")));
        holder.setGameRoot(nextRoot);

        holder.getCurrentLevel().start();
        Stage stage6 = new Stage();
        stage6.setTitle("Game");
        stage6.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_icon.png")));

        // Mise à jour des avatars
        ImageView wizardAvatar = (ImageView) holder.getGameRoot().lookup("#wizardAvatar");
        ImageView enemyAvatar = (ImageView) holder.getGameRoot().lookup("#enemyAvatar");
        wizardAvatar.setImage(holder.getWizard().getAvatar());
        enemyAvatar.setImage(holder.getCurrentLevel().getEnemy().getAvatar());

        //Mise à jour du label des niveaux
        Label levelLabel = (Label) holder.getGameRoot().lookup("#levelLabel");
        levelLabel.setText(" LEVEL " + holder.getCurrentLevel().getName());
        levelLabel.setText(" LEVEL " +  holder.getCurrentLevel().getNumber() + " : " + holder.getCurrentLevel().getName());

        Label figthInfo = (Label) holder.getGameRoot().lookup("#fightLabel");
        Label wizardName = (Label) holder.getGameRoot().lookup("#wizardName");
        Label enemyName = (Label) holder.getGameRoot().lookup("#enemyName");
        Label wHealth = (Label) holder.getGameRoot().lookup("#wHealth");
        Label eHealth = (Label) holder.getGameRoot().lookup("#eHealth");


        Button quitGame = (Button) holder.getGameRoot().lookup("#quitGame");
        HBox playButtons = (HBox) holder.getGameRoot().lookup("#playButtons");
        Button continueGame = (Button) holder.getGameRoot().lookup("#continueGame");
        Button restartGame = (Button) holder.getGameRoot().lookup("#restartGame");

        continueGame.setVisible(false);
        restartGame.setVisible(false);
        quitGame.setVisible(true);
        playButtons.setVisible(true);
        wizardName.setText(holder.getWizard().getName().toUpperCase());
        enemyName.setText(holder.getCurrentLevel().getEnemy().getName().toUpperCase());
        wHealth.setText("Health : " +holder.getWizard().health);
        eHealth.setText("Health : " +holder.getCurrentLevel().getEnemy().health);
        figthInfo.setText(" WAITING FOR YOUR ACTION TO START THE FIGHT ...");
        EntityHolder.getInstance().getGameStage().close();

        stage6.setScene(new Scene(holder.getGameRoot()));
        stage6.show();
        holder.setGameStage(stage6);
        holder.getRecapStage().close();
        }else{
            Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/champion.fxml")));
            holder.setChampionRoot(nextRoot);
            Stage stage7 = new Stage();
            stage7.setTitle("CHAMPION");
            stage7.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_icon.png")));
            stage7.setScene(new Scene(nextRoot));
            stage7.show();
            holder.getGameStage().close();
        }

    }

    public void restartGame(ActionEvent event) {
        new HarryPotterJfxApp();
        EntityHolder.getInstance().getWizardStage().show();
        EntityHolder.getInstance().getGameStage().close();
    }

    public void defend() {
        Enemy enemy = holder.getCurrentLevel().getEnemy();
        Wizard wizard = holder.getWizard();
        Level level = holder.getCurrentLevel();
        attackButton = (Button) holder.getGameRoot().lookup("#attack");
        defendButton = (Button) holder.getGameRoot().lookup("#defend");
        figthInfo = (Label) holder.getGameRoot().lookup("#fightLabel");
        Button quitGame = (Button) holder.getGameRoot().lookup("#quitGame");
        Button continueGame = (Button) holder.getGameRoot().lookup("#continueGame");
        Button restartGame = (Button) holder.getGameRoot().lookup("#restartGame");
        HBox playButtons = (HBox) holder.getGameRoot().lookup("#playButtons");

        Label wHealth = (Label) holder.getGameRoot().lookup("#wHealth");
        Label eHealth = (Label) holder.getGameRoot().lookup("#eHealth");

        continueGame.setVisible(false);
        restartGame.setVisible(false);
        playButtons.setVisible(true);
        quitGame.setVisible(true);
        playButtons.setVisible(true);



        if (wizard.IsAlive() && enemy.IsAlive()) {
            System.out.println("You choose to attack..");
            System.out.println("santé " + enemy.getName() + " : " + enemy.getHealth());
            System.out.println("santé wizard : " + wizard.getHealth());

            System.out.println();
            System.out.println("You choose to defend");

            gameMessage = wizard.defend(enemy, level);
            System.out.println();

            System.out.println("gameMessage : " + gameMessage);

            System.out.println();

            System.out.println("santé " + enemy.getName() + " : " + enemy.health);
            System.out.println("santé wizard : " + wizard.health);

            wHealth.setText("Health : " +holder.getWizard().health);
            eHealth.setText("Health : " +holder.getCurrentLevel().getEnemy().health);

            figthInfo.setText(gameMessage);

        }
        if (!wizard.IsAlive()) {
            System.out.println(Constant.customDisplayText(Constant.YELLOW, wizard.getName() + ", " + enemy.getName() + " just killed you..."));
            System.out.println(Constant.customDisplayText(Constant.RED, wizard.getName() + ", " + enemy.getName() + " GAME OVER !!! "));
            gameMessage = wizard.getName() + ", " + enemy.getName() + " just killed you..."
                    + "\n Continue or exit game ? \n\n\n";
            figthInfo.setText(gameMessage);
            figthInfo.setTextFill(Color.RED);
            wHealth.setTextFill(Color.RED);
            continueGame.setVisible(false);
            restartGame.setVisible(true);
            playButtons.setVisible(false);
        } else if (!enemy.IsAlive()) {
            gameMessage = "Congratulation " + wizard.getName() + ", " + "you just killed " + enemy.getName()
                    + "\n Continue or exit game ? \n";
            System.out.println(Constant.customDisplayText(Constant.GREEN, "Congratulation " + wizard.getName() + ", " + "you just killed " + enemy.getName()));
            figthInfo.setText(gameMessage);
            figthInfo.setTextFill(Color.GREEN);
            eHealth.setTextFill(Color.RED);
            playButtons.setVisible(false);
            continueGame.setVisible(true);
            restartGame.setVisible(true);
        }

    }


}
