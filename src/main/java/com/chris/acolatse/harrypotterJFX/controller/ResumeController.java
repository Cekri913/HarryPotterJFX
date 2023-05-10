package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.SortingHat;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import java.net.URLConnection;


import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;

public class ResumeController {
    @FXML private VBox layout;
    @FXML private Label resumeLabel;

    public Wizard wizard;

    private String pseudo;
    private String animal;
    private String core;
    private String maison;

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public void setMaison(String maison) {
        this.maison = maison;
    }
    public void Initialize(ResourceBundle resourceBundle) throws IOException {
        resumeWizard(wizard);
    }
    public void resumeWizard(Wizard wizard) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/resume.fxml")));
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);

        resumeLabel.setText("ca marche");

        SortingHat sortingHat = new SortingHat();
        wizard.assignHouse(sortingHat);

        System.out.println("Résumé du wizard :");
        System.out.println("Nom : " + WizardController.pseudo);
        System.out.println("Maison : " + wizard.getHouse().name);
        System.out.println("Core : " + CoreController.selectedCore);
        System.out.println("Animal : " + AnimalController.selectedAnimal);

        stage.show();


    }

    @FXML
    private void quitterJeu() {
        System.exit(0);
    }
}
