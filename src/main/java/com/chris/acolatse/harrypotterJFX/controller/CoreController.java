package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Core;
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
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class CoreController {

    public static String selectedCore;
    public Label coreInput;
    @FXML
    ChoiceBox<Core> coreChoice;
    WizardController wizardController;
    @FXML
    TextField pseudoInput;

    @FXML
    private Label pseudoLabel;

    @FXML
    public void showPet(ActionEvent actionEvent) throws IOException {

        Parent coreRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/pet.fxml")));
        pseudoLabel = (Label) coreRoot.lookup("#pseudoLabel");
        System.out.println(coreChoice.getValue());
        Core coreSelected;

       /* for (Core c : Core.valueOf()) {
            if (coreChoice.getValue() == c.get) {
                String choice;
                choice = String.valueOf(c);
            }
        }*/

        UserHolder holder = UserHolder.getInstance();
        //  holder.setCore(coreChoice.getValue().);

        //System.out.println(holder.getCore().name());
        System.out.println(holder.getWizard().getName());
        System.out.println(holder.getWizard().health);
        // holder.setWizard( new Core());
        pseudoLabel.setText("Votre pseudo est : " + UserHolder.getInstance().getWizard().getName());

        Stage thirdStage = new Stage();
        thirdStage.setTitle("Choix du core");
        thirdStage.setScene(new Scene(coreRoot));
        thirdStage.show();
        Stage wizarsStage = (Stage) wizardController.pseudoInput.getScene().getWindow();
        wizarsStage.close();

        if(coreChoice != null) {
            coreChoice.setValue(coreChoice.getValue());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/pet.fxml")));
            Stage fourthStage = new Stage();
            fourthStage.setTitle("Choix de l'animal");
            fourthStage.setScene(new Scene(root));
            fourthStage.show();
           // fourthStage.setu
        }
    }

    public void backToWizardStep(ActionEvent actionEvent) throws IOException {
        /*
        Parent coreRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml")));
        pseudoLabel = (Label) coreRoot.lookup("#pseudoLabel");
        pseudoLabel.setText("Votre pseudo est : " + pseudoInput.getText());

        Stage thirdStage = new Stage();
        thirdStage.setTitle("Choix du core");
        thirdStage.setScene(new Scene(coreRoot));
        thirdStage.show();
        Stage wizarsStage = (Stage) pseudoInput.getScene().getWindow();
       wizarsStage.close();
    }

 */
    }
}
