package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.SortingHat;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PetController {
    public static String selectedAnimal;
    @FXML
    public ChoiceBox<String> petChoice;

    Wizard wizard;
    WizardController wizardController;
    CoreController coreController;
    PetController petController;
    @FXML

    public Label pseudoLabel, resumeLabel;
    @FXML
    public VBox layout;


    public void showRecap(ActionEvent actionEvent) throws IOException {
        if (petChoice != null) {


            petChoice.setValue(petChoice.getValue());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/recap.fxml")));
            Stage fifthStage = new Stage();
            fifthStage.setTitle("Recap");

            fifthStage.setScene(new Scene(root));
            fifthStage.show();
        }
        else {
            System.out.println("Please choose a pet");

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/pet.fxml")));
            Stage fourthStage = new Stage();
            fourthStage.setTitle("Choix de l'animal");
            fourthStage.setScene(new Scene(root));
            fourthStage.show();
        }
    }
}
