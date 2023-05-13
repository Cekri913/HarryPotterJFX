package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.*;
import com.chris.acolatse.harrypotterJFX.utils.TextAnimator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PetController implements Initializable {
    @FXML
    public ChoiceBox<String> petChoice;
    EntityHolder holder = EntityHolder.getInstance();

    @FXML
    private Label nameLabel;

    TextAnimator textAnimator;

    @FXML
    private Text text;

    Label resumeLabel;

    TextOutput textOutput = new TextOutput() {
        @Override
        public void writeText(String textOut) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    resumeLabel.setText(textOut);
                }
            });
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    void lunchGame(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wizard.fxml")));

        Stage secondStage = new Stage();
        secondStage.setTitle("Character Creator");
        secondStage.setScene(new Scene(root));
        secondStage.show();
    }

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



        resumeLabel = (Label) holder.getRecapRoot().lookup("#resumeLabel");

        String message = "Pseudo : " + EntityHolder.getInstance().getWizard().getName()
                        + "\nCore : " + EntityHolder.getInstance().getCore().name()
                        + "\nPet : " + EntityHolder.getInstance().getPet().name() +"\n";

        textAnimator = new TextAnimator(message,80, textOutput);
        Thread thread = new Thread(textAnimator);
        thread.start();

        Stage stage5 = new Stage();
        stage5.setTitle("Recap");
        stage5.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_icon.png")));
        stage5.setScene(new Scene(nextRoot));
        stage5.show();

        holder.setRecapStage(stage5);
        holder.getPetStage().hide();
    }

    public void backToCoreStep(ActionEvent event) {
        EntityHolder.getInstance().getCoreStage().show();
        EntityHolder.getInstance().getPetStage().hide();
    }
}
