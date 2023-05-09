package com.chris.acolatse.harrypotterJFX.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class WizardController {

    public static String pseudo;
    @FXML
    private VBox layout;

    @FXML
    private TextField pseudoInput;

    @FXML
    private Label pseudoLabel;

    @FXML
    private Button continuer;

    @FXML
    public void continuer() throws IOException {
        String pseudo = pseudoInput.getText();
        pseudoInput.setText(pseudo);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
        Stage thirdStage = new Stage();
        thirdStage.setTitle("Choix du core");
        thirdStage.setScene(new Scene(root));
        thirdStage.show();


    }

}
