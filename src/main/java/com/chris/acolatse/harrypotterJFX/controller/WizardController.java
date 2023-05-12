package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Core;
import com.chris.acolatse.harrypotterJFX.entity.UserHolder;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class WizardController {

    @FXML
    TextField pseudoInput = new TextField();

    UserHolder holder = UserHolder.getInstance();;


    @FXML
    public void coreChoice() throws IOException {
        System.out.println(pseudoInput.getText());

        if(!pseudoInput.getText().isEmpty()){

            Parent currentRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wizard.fxml")));
            Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
            holder.setWizardRoot(currentRoot);
            holder.setCoreRoot(nextRoot);

            Label pseudoLabel = (Label) holder.getCoreRoot().lookup("#pseudoLabel");
            ChoiceBox<Object> choiceBox = (ChoiceBox) holder.getCoreRoot().lookup("#coreChoice");

            for (Core c : Core.values()) {
                choiceBox.getItems().add(c);
            }

            // Le choix par defaut
            choiceBox.setValue(Core.PHOENIX_FEATHER);

            holder = UserHolder.getInstance();
            holder.setWizard( new Wizard(pseudoInput.getText()));
            pseudoLabel.setText("Votre pseudo est : " + UserHolder.getInstance().getWizard().getName());

            Stage thirdStage = new Stage();
            thirdStage.setTitle("Choix du core");
            thirdStage.setScene(new Scene(nextRoot));
            thirdStage.show();
            Stage wizardsStage = (Stage) pseudoInput.getScene().getWindow();

            holder.setWizardStage(wizardsStage);
            holder.setCoreStage(thirdStage);

            wizardsStage.hide();

        }else{
            System.out.println("Please fill the field.");
            pseudoInput.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
            pseudoInput.setPromptText("Please fill the field !");
        }

    }

}
