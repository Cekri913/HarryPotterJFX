package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.UserHolder;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class WizardController {

    @FXML
    static
    TextField pseudoInput = new TextField();

    @FXML
    private Label pseudoLabel;

    @FXML
    public void continuer() throws IOException {
        System.out.println(pseudoInput.getText());

        if(!pseudoInput.getText().isEmpty()){
            Parent coreRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
            pseudoLabel = (Label) coreRoot.lookup("#pseudoLabel");

            UserHolder holder = UserHolder.getInstance();
            holder.setWizard( new Wizard(pseudoInput.getText()));
            pseudoLabel.setText("Votre pseudo est : " + UserHolder.getInstance().getWizard().getName());

            Stage thirdStage = new Stage();
            thirdStage.setTitle("Choix du core");
            thirdStage.setScene(new Scene(coreRoot));
            thirdStage.show();
            Stage wizarsStage = (Stage) pseudoInput.getScene().getWindow();
            wizarsStage.close();

        }else{
           System.out.println("Please fill the field.");
           pseudoLabel.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
           pseudoLabel.setText("Please fill the field !");
        }

    }

}
