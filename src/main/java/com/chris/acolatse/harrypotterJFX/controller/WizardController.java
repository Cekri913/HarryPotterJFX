package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.UserHolder;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class WizardController {

    @FXML
    static
    TextField nameInput = new TextField();

    @FXML
    Label nameLabel;

    @FXML
    public void coreChoice() throws IOException {
        System.out.println(nameInput.getText());

        if(nameInput.getText().isEmpty() && nameLabel != null){
            Parent coreRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
            nameLabel = (Label) coreRoot.lookup("#nameLabel");

            UserHolder holder = UserHolder.getInstance();
            holder.setWizard( new Wizard(nameInput.getText()));
            nameLabel.setText("Votre pseudo est : " + UserHolder.getInstance().getWizard().getName());

            Stage thirdStage = new Stage();
            thirdStage.setTitle("Choix du core");
            thirdStage.setScene(new Scene(coreRoot));
            thirdStage.show();
           // Stage wizardStage = (Stage) pseudoInput.getScene().getWindow();
           // wizardStage.close();

        }else{

            assert nameLabel != null;
            nameLabel.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
           nameLabel.setText("Please fill the field !");
        }

    }

}
