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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PetController {
    public static String selectedAnimal;
    @FXML
    public static ChoiceBox<String> petChoice;
    @FXML
            private Label petLabel;
    static String petSelected;

    Wizard wizard ;
    WizardController wizardController;
    CoreController coreController;
    PetController petController;
    @FXML
    TextField pseudoInput;

    public Label pseudoLabel, resumeLabel;
    @FXML
    public VBox layout;


    public void showRecap(ActionEvent actionEvent) throws IOException {
        if (petChoice.getValue() != null) {
            petSelected = petChoice.getValue();
            System.out.println(petSelected);
            //String name = WizardController.pseudoInput.getText();
            //String pet = petChoice.getValue();
            //String core = CoreController.selectedCore;

            //wizard = new Wizard(name);


            //petChoice.setValue(petChoice.getValue());

            // SortingHat sortingHat = new SortingHat();
            //wizard.assignHouse(sortingHat);


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/recap.fxml")));
            Stage fifthStage = new Stage();
            fifthStage.setTitle("Recap");

            //resumeLabel.setText("name : " + name + "pet : " + pet + "core : " + core + "house : " + wizard.getHouse().name);

            fifthStage.setScene(new Scene(root));
            fifthStage.show();
        }
        else {
            petLabel.setText("Please choose a pet");
        }
    }
}

