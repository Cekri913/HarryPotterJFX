package com.chris.acolatse.harrypotterJFX.controller;

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

public class AnimalController {
    public static String selectedAnimal;
    @FXML
    public ChoiceBox<String> animalChoiceBox;

    public Label pseudoLabel;
    @FXML
    public VBox layout;


    public void afficherResume(ActionEvent actionEvent) throws IOException {
        String selectedAnimal = animalChoiceBox.getValue();
        animalChoiceBox.setValue(selectedAnimal);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/resume.fxml")));
        Stage fifthStage = new Stage();
        fifthStage.setTitle("Résumé");
        fifthStage.setScene(new Scene(root));
        fifthStage.show();

    }
}
