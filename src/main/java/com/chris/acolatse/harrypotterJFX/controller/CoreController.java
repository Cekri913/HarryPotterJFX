package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Core;
import com.chris.acolatse.harrypotterJFX.entity.Pets;
import com.chris.acolatse.harrypotterJFX.entity.EntityHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

import static com.chris.acolatse.harrypotterJFX.entity.Pets.*;

public class CoreController {
    EntityHolder holder = EntityHolder.getInstance();

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

        RadioButton catRButton = (RadioButton) holder.getPetRoot().lookup("#catRButton");
        catRButton.setText(String.valueOf(CAT));
        catRButton.setSelected(true);
        RadioButton owlRButton = (RadioButton) holder.getPetRoot().lookup("#owlRButton");
        owlRButton.setText(String.valueOf(OWL));
        RadioButton toadRButton = (RadioButton) holder.getPetRoot().lookup("#toadRButton");
        toadRButton.setText(String.valueOf(TOAD));
        RadioButton ratRButton = (RadioButton) holder.getPetRoot().lookup("#ratRButton");
        ratRButton.setText(String.valueOf(RAT));

        Stage stage4 = new Stage();
        stage4.setTitle("Pet Choice");
        stage4.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_icon.png")));
        stage4.setScene(new Scene(holder.getPetRoot()));
        stage4.show();
        holder.setPetStage(stage4);
        holder.getCoreStage().close();
    }

    public void backToWizardStep(ActionEvent actionEvent) throws IOException {
        EntityHolder.getInstance().getWizardStage().show();
        EntityHolder.getInstance().getCoreStage().close();

    }


}

