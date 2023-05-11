package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.SortingHat;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//import java.net.URLConnection;


import java.io.IOException;
import java.util.Objects;

public class RecapController {
   // @FXML private VBox layout;
    @FXML private Label resumeLabel;

    public Wizard wizard;

    private String pseudo;

    WizardController wizardController;
    PetController petController =  new PetController();
    CoreController coreController;
    private String animal;
    private String core;
    private String maison;

    public void recapWizard() throws IOException {
        String name = WizardController.nameInput.getText();
        String pet = PetController.petSelected;
        String core = CoreController.selectedCore;

        wizard = new Wizard(name);


        //petChoice.setValue(petChoice.getValue());

        SortingHat sortingHat = new SortingHat();
        wizard.assignHouse(sortingHat);
       // resumeLabel.setText("name : " + wizard.getName() + "pet : " + wizard.getPet() + "core : " + wizard.getCore() + "house : " + wizard.getHouse().name);
        //VBox root = new VBox();
        //Label label = new Label(String.format("name : " + wizard.getName() + "pet : " + wizard.getPet() + "core : " + wizard.getCore() + "house : " + wizard.getHouse().name));
        //label.getStyleClass().add("label");
        //root.getStyleClass().add("vbox");
        resumeLabel.setText("name : " + name + "pet : " + pet + "core : " + core + "house : " + wizard.getHouse().name);
        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml")));
        //Stage sixthStage = new Stage();
        //sixthStage.setTitle("Game");
        //sixthStage.setScene(new Scene(root));
        //sixthStage.show();
    }

    public void Play(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml")));
        Stage sixthStage = new Stage();
        sixthStage.setTitle("Game");
        sixthStage.setScene(new Scene(root));
        sixthStage.show();
    }

    @FXML
    private void quitterJeu() {
        System.exit(0);
    }


}