package com.chris.acolatse.harrypotterJFX.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
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
    TextField pseudoInput;

    @FXML
    private Label pseudoLabel;

    @FXML
    private Button continuer;

    /*
    public WizardController(TextField pseudoInput){
        this.pseudoInput = pseudoInput;
    }
*/
    @FXML
    public void continuer() throws IOException {
        if(pseudoInput !=null) {
            pseudoInput.setText(pseudoInput.getText());


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
            Stage thirdStage = new Stage();
            thirdStage.setTitle("Choix du core");
            thirdStage.setScene(new Scene(root));
            thirdStage.show();
        }
        else{
            System.out.println("Please fill the field.");

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wizard.fxml")));
            Stage fourthStage = new Stage();
            fourthStage.setTitle("Créateur de personnage");
            fourthStage.setScene(new Scene(root));
            fourthStage.show();
        }


    }

}
