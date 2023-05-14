package com.chris.acolatse.harrypotterJFX.controller;


import com.chris.acolatse.harrypotterJFX.entity.EntityHolder;
import com.chris.acolatse.harrypotterJFX.entity.TextOutput;
import com.chris.acolatse.harrypotterJFX.utils.Constant;
import com.chris.acolatse.harrypotterJFX.utils.TextAnimator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    TextAnimator textAnimator;
    EntityHolder holder = EntityHolder.getInstance();
    ;

    @FXML
    private Text text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> text.setText(textOut));

        textAnimator = new TextAnimator(Constant.welcomeText,
                50, textOutput);

        Thread thread = new Thread(textAnimator);
        thread.start();
    }
        @FXML
        void lunchGame (ActionEvent event) throws IOException {

            Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wizard.fxml")));
            holder.setWizardRoot(nextRoot);

            Stage secondStage = new Stage();
            secondStage.setTitle("Character Creator");
            secondStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_icon.png")));
            secondStage.setScene(new Scene(holder.getWizardRoot()));
            secondStage.show();
            holder.setWizardStage(secondStage);
            holder.getStartStage().close();
        }

        @FXML
        void exitGame (ActionEvent event){
            Platform.exit();
        }


}