package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.*;
import com.chris.acolatse.harrypotterJFX.utils.Constant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import java.net.URLConnection;


import java.io.IOException;
import java.util.Objects;

public class RecapController {
    @FXML private Label resumeLabel;

    public Wizard wizard;

    EntityHolder holder = EntityHolder.getInstance();

    public void Play() throws IOException {
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

        stage6.setScene(new Scene(holder.getGameRoot()));
        stage6.show();
        holder.setGameStage(stage6);
        holder.getRecapStage().close();
    }

    public void backToPetStep(ActionEvent event) {
        EntityHolder.getInstance().getRecapStage().close();
        EntityHolder.getInstance().getPetStage().show();
    }


    public void exitGame() {
        //#backToPetStep
    }
}
