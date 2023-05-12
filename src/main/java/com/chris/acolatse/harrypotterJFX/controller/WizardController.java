package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Core;
import com.chris.acolatse.harrypotterJFX.entity.UserHolder;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class WizardController {

    @FXML
    TextField nameInput = new TextField();

    UserHolder holder = UserHolder.getInstance();

    @FXML
    public void coreChoice() throws IOException {
        System.out.println(nameInput.getText());

        if(!nameInput.getText().isEmpty()){
            Parent currentRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wizard.fxml")));
            Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
            holder.setWizardRoot(currentRoot);
            holder.setCoreRoot(nextRoot);

            Label nameLabel = (Label) holder.getCoreRoot().lookup("coreChoice");
            ChoiceBox<Object> choiceBox = (ChoiceBox) holder.getCoreRoot().lookup("#coreChoice");
            for (Core c : Core.values()){
                choiceBox.getItems().add(c);
            }

            //default choice
            choiceBox.setValue(Core.PHOENIX_FEATHER);

            holder = UserHolder.getInstance();
            holder.setWizard( new Wizard(nameInput.getText()));
            nameLabel.setText("Your name is : " + UserHolder.getInstance().getWizard().getName());

            Stage thirdStage = new Stage();
            thirdStage.setTitle("Core choice");
            thirdStage.setScene(new Scene(nextRoot));
            thirdStage.show();
            Stage wizardsStage = (Stage) nameInput.getScene().getWindow();

            holder.setWizardStage(wizardsStage);
            holder.setCoreStage(thirdStage);

            wizardsStage.hide();

        }else{
            nameInput.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
            nameInput.setPromptText("Please fill the field");
        }

    }

}
