package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.*;
import com.chris.acolatse.harrypotterJFX.utils.TextAnimator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PetController implements Initializable {
    EntityHolder holder = EntityHolder.getInstance();

    TextAnimator textAnimator;

    Button backButton;

    Label resumeLabel;

    TextOutput textOutput = new TextOutput() {
        @Override
        public void writeText(String textOut) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    resumeLabel.setText(textOut);
                }
            } );
        }

    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void showRecap() throws IOException, InterruptedException {
        Pets selectedPet = null;
        String petChoice = null;

        Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/recap.fxml")));
        holder.setRecapRoot(nextRoot);

        RadioButton catRButton = (RadioButton) holder.getPetRoot().lookup("#catRButton");
        RadioButton toadRButton = (RadioButton) holder.getPetRoot().lookup("#toadRButton");
        RadioButton ratRButton = (RadioButton) holder.getPetRoot().lookup("#ratRButton");
        RadioButton owlRButton = (RadioButton) holder.getPetRoot().lookup("#owlRButton");


        if (catRButton.isSelected()){
            petChoice = catRButton.getText();
        } else if (ratRButton.isSelected())
            petChoice = ratRButton.getText();
        else if (owlRButton.isSelected()) {
            petChoice = owlRButton.getText();
        } else if (toadRButton.isSelected()) {
            petChoice = toadRButton.getText();
        }

        for (Pets pet : Pets.values()) {
            if (Objects.equals(petChoice, pet.name())) {
                selectedPet=pet;
            };
        }
        holder.setPet(selectedPet);

       resumeLabel = (Label) holder.getRecapRoot().lookup("#resumeLabel");
       backButton = (Button) holder.getRecapRoot().lookup("#back");

       String message = "Pseudo : " + EntityHolder.getInstance().getWizard().getName()
                        + "\nCore : " + EntityHolder.getInstance().getCore().name()
                        + "\nPet : " + EntityHolder.getInstance().getPet().name() +"\n";

        textAnimator = new TextAnimator(message,80, textOutput);
        Thread thread = new Thread(textAnimator);

        Stage stage5 = new Stage();
        stage5.setTitle("Recap");
        stage5.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_icon.png")));
        stage5.setScene(new Scene(holder.getRecapRoot()));
        stage5.show();

        holder.setRecapStage(stage5);
        holder.getPetStage().close();
        thread.start();
    }

    public void backToCoreStep() {
        EntityHolder.getInstance().getCoreStage().show();
        EntityHolder.getInstance().getPetStage().close();
    }
}
