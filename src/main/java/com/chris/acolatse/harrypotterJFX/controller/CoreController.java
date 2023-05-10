package com.chris.acolatse.harrypotterJFX.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class CoreController {

    public static String selectedCore;
    public Label coreInput;
    @FXML
    ChoiceBox<String> coreChoice;

    @FXML
    private Label pseudoLabel;

    @FXML
    public void showPet(ActionEvent actionEvent) throws IOException {
        if(coreChoice != null) {
            coreChoice.setValue(coreChoice.getValue());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/pet.fxml")));
            Stage fourthStage = new Stage();
            fourthStage.setTitle("Choix de l'animal");
            fourthStage.setScene(new Scene(root));
            fourthStage.show();
        }
        else{
            System.out.println("Please choose a core");
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
            Stage fourthStage = new Stage();
            fourthStage.setTitle("Choix du core");
            fourthStage.setScene(new Scene(root));
            fourthStage.show();
        }


    }

}
