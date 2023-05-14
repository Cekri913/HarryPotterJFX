package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class WizardController implements Initializable {

    @FXML
    TextField pseudoInput = new TextField();

    EntityHolder holder = EntityHolder.getInstance();


    @FXML
    public void coreChoice() throws IOException {
        holder.setLevel1(new Level(1, new Enemy(1), "The Philosopher's stone"));
        holder.setLevel2(new Level(2, new Enemy(2), "The Chamber of Secrets"));
        holder.setLevel3(new Level(3, new Enemy(3) ,"The Prisoner of Azkaban"));
        holder.setLevel4(new Level(4, new Enemy(4), "The Goblet of Fire"));
        holder.setLevel5(new Level(5, new Enemy(5), "The Order of the Phenix"));

        holder.setLevel6(new Level(6, new Enemy(6), "The Half-Blood Prince"));
        holder.setLevel7(new Level(7, new Enemy(7), "The Deathly Hallows"));

        holder.setLevelId(1); //Le jeu commence toujours par le niveau 1

        holder.setCurrentLevel();

        System.out.println("level id  : " + holder.getLevelId());
        System.out.println("current level  : " + holder.getCurrentLevel());

        System.out.println(pseudoInput.getText());

        if(!pseudoInput.getText().isEmpty()){

            Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
            holder.setCoreRoot(nextRoot);

            Label pseudoLabel = (Label) holder.getCoreRoot().lookup("#pseudoLabel");
            ChoiceBox<Object> choiceBox = (ChoiceBox) holder.getCoreRoot().lookup("#coreChoice");

            for (Core c : Core.values()) {
                choiceBox.getItems().add(c);
            }

            // Le choix par defaut
            choiceBox.setValue(Core.PHOENIX_FEATHER);

            Wizard wizard = new Wizard(pseudoInput.getText());
            wizard.assignHouse(new SortingHat());
            holder.setWizard(wizard);

            Stage thirdStage = new Stage();
            thirdStage.setTitle("Core Choice");
            thirdStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_icon.png")));
            thirdStage.setScene(new Scene(holder.getCoreRoot()));
            thirdStage.show();
            holder.setCoreStage(thirdStage);
            holder.getWizardStage().close();

        }else{
            System.out.println("Please fill the field.");
            pseudoInput.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
            pseudoInput.setPromptText("Please fill the field !");
        }

    }

    public void backToStart(ActionEvent event) {
        EntityHolder.getInstance().getWizardStage().close();
        EntityHolder.getInstance().getStartStage().show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
