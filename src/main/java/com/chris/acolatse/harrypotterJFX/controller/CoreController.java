package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Core;
import com.chris.acolatse.harrypotterJFX.entity.Pets;
import com.chris.acolatse.harrypotterJFX.entity.UserHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class CoreController {
    UserHolder holder = UserHolder.getInstance();

    @FXML
    public void showPet(ActionEvent actionEvent) throws IOException {

        Core selectedCore = null;
        ChoiceBox<Object> choiceBox = (ChoiceBox) holder.getCoreRoot().lookup("#coreChoice");

        System.out.println("    choiceBox.getValue() : " + choiceBox.getValue());

        for(Core c : Core.values()){
            if(Objects.equals(choiceBox.getValue().toString(), c.name())){
                selectedCore = c;
            };
        }
        holder.setCore(selectedCore);

        //Init next screen

        Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/pet.fxml")));
        holder.setPetRoot(nextRoot);

        Label nameLabel = (Label) holder.getPetRoot().lookup("#nameLabel");
        nameLabel.setText("Name : " + holder.getPetRoot().lookup("#petChoice"));
        choiceBox = (ChoiceBox) holder.getPetRoot().lookup(("#petChoice"));

        for (Pets pet : Pets.values()){
            choiceBox.getItems().add(pet);
        }
        //choice default

        choiceBox.setValue(Pets.OWL);

        System.out.println("default pet value : " + choiceBox.getValue());

        Stage stage4 = new Stage();
        stage4.setTitle("Pet Choice");
        stage4.setScene(new Scene(nextRoot));
        stage4.show();
        holder.setPetStage(stage4);
        holder.getCoreStage().hide();



    }

    public void backToWizardStep(ActionEvent actionEvent) throws IOException {
        UserHolder.getInstance().getWizardStage().show();
        UserHolder.getInstance().getCoreStage().hide();

    }


}

