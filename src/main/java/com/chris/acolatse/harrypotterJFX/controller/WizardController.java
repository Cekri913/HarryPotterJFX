package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Core;
import com.chris.acolatse.harrypotterJFX.entity.EntityHolder;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class WizardController {

    @FXML
    TextField pseudoInput = new TextField();
    ToggleGroup coreGroup;
    @FXML
            private VBox container;

    EntityHolder holder = EntityHolder.getInstance();


    @FXML
    public void coreChoice() throws IOException {
        System.out.println(pseudoInput.getText());

        if(!pseudoInput.getText().isEmpty()){

            Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
            holder.setCoreRoot(nextRoot);

            Label pseudoLabel = (Label) holder.getCoreRoot().lookup("#pseudoLabel");
            //RadioButton radioButton = (RadioButton) coreGroup.getSelectedToggle();
            ToggleGroup toggleGroup = (ToggleGroup) holder.getCoreRoot().lookup("#coreGroup");

            for (Core c : Core.values() ) {
                RadioButton button = new RadioButton(c.name());
                button.setToggleGroup(coreGroup);
                container.getChildren().add(button);
            }

            // Le choix par defaut -> pas possible pour un toggle
            //toggleGroup.equals(Core.PHOENIX_FEATHER);

            holder = EntityHolder.getInstance();
            holder.setWizard( new Wizard(pseudoInput.getText()));
            pseudoLabel.setText("Your name is : " + EntityHolder.getInstance().getWizard().getName());

            Stage thirdStage = new Stage();
            thirdStage.setTitle("Core Choice");
            thirdStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/app_icon.png"))));
            thirdStage.setScene(new Scene(nextRoot));
            thirdStage.show();
            holder.setCoreStage(thirdStage);
            holder.getWizardStage().hide();

        }else{
            System.out.println("Please fill the field.");
            pseudoInput.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
            pseudoInput.setPromptText("Please fill the field !");
        }

    }

    public void backToStart(ActionEvent event) {
        EntityHolder.getInstance().getWizardStage().hide();
        EntityHolder.getInstance().getStartStage().show();
    }
}
