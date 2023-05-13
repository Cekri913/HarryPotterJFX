package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.SortingHat;
import com.chris.acolatse.harrypotterJFX.entity.EntityHolder;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
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
    PetController petController;

    EntityHolder holder = EntityHolder.getInstance();
    CoreController coreController;
    private String animal;
    private String core;
    private String maison;

    public void recapWizard() {
        String name = wizardController.pseudoInput.getText();
        String pet = petController.petChoice.getValue();

        SortingHat sortingHat = new SortingHat();
        wizard.assignHouse(sortingHat);
        Character character = new Character(name, pet, core);
        VBox root = new VBox();
        Label label = new Label(String.format("name : " + wizard.getName() + "pet : " + wizard.getPet() + "core : " + wizard.getCore() + "house : " + wizard.getHouse().name));
        label.getStyleClass().add("label");
        root.getStyleClass().add("vbox");
    }

    public void Play(ActionEvent actionEvent) throws IOException {
        Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml")));
        holder.setGameRoot(nextRoot);
        Stage stage6 = new Stage();
        stage6.setTitle("Game");
        stage6.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_icon.png")));
        stage6.setScene(new Scene(nextRoot));
        stage6.show();
        holder.setGameStage(stage6);
        holder.getRecapStage().close();
    }

    public void backToPetStep(ActionEvent event) {
        EntityHolder.getInstance().getRecapStage().hide();
        EntityHolder.getInstance().getPetStage().show();
    }
}
