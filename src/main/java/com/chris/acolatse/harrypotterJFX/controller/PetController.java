package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Pets;
import com.chris.acolatse.harrypotterJFX.entity.SortingHat;
import com.chris.acolatse.harrypotterJFX.entity.UserHolder;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PetController {
    @FXML
    public ChoiceBox<String> petChoice;
    UserHolder holder = UserHolder.getInstance();

    @FXML
    private Label nameLabel;


    public void showRecap(ActionEvent actionEvent) throws IOException {
        Pets selectedPet = null;
        ChoiceBox<Object> petChoiceBox = (ChoiceBox) holder.getPetRoot().lookup("#petChoice");

        System.out.println("   selectedPet: " + petChoiceBox.getValue());

        for (Pets pet : Pets.values()) {
            if (Objects.equals(petChoiceBox.getValue().toString(), pet.name())) {
                selectedPet=pet;
            };
        }
        holder.setPet(selectedPet);

        // Init next screen

        Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/recap.fxml")));
        holder.setRecapRoot(nextRoot);

        Label resumeLabel = (Label) holder.getRecapRoot().lookup("#resumeLabel");
        resumeLabel.setText("Pseudo : " + UserHolder.getInstance().getWizard().getName()
                + "\nCore : " + UserHolder.getInstance().getCore().name()
                + "\nPet : " + UserHolder.getInstance().getPet().name());

        Stage stage5 = new Stage();
        stage5.setTitle("Recap");
        stage5.setScene(new Scene(nextRoot));
        stage5.show();

        holder.setRecapStage(stage5);
        holder.getPetStage().hide();
    }

    public void backToCoreStep(ActionEvent event) {
        UserHolder.getInstance().getCoreStage().show();
        UserHolder.getInstance().getPetStage().hide();
    }
}
