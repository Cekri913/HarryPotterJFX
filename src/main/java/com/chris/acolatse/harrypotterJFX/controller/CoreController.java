package com.chris.acolatse.harrypotterJFX.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class CoreController {

    public static String selectedCore;
    public Label coreInput;
    @FXML
    private VBox layout;

    @FXML
    private TextField pseudoInput;

    @FXML
    private ChoiceBox<String> coreChoiceBox;

    @FXML
    private Label pseudoLabel;

    @FXML
    private Button continuer;

    @FXML
    public void afficherPageAnimal() throws IOException {
        String selectedCore = coreChoiceBox.getValue();
        coreChoiceBox.setValue(selectedCore);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/animal.fxml")));
        Stage fourthStage = new Stage();
        fourthStage.setTitle("Choix de l'animal");
        fourthStage.setScene(new Scene(root));
        fourthStage.show();


    }

}
