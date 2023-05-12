package com.chris.acolatse.harrypotterJFX.controller;


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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    TextAnimator textAnimator;

    @FXML
    private Text text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TextOutput textOutput = new TextOutput() {
            @Override
            public void writeText(String textOut) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(textOut);
                    }
                });
            }
        };


        textAnimator = new TextAnimator(Constant.welcomeText,
                25, textOutput);
    }

    @FXML
    void lunchGame(ActionEvent event) throws IOException {
        System.out.println("Thread : " + Thread.currentThread().getName());
        Thread thread = new Thread(textAnimator);
        thread.start();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wizard.fxml")));

        Stage secondStage = new Stage();
        secondStage.setTitle("Character Creator");
        secondStage.setScene(new Scene(root));
        secondStage.show();
    }

    @FXML
    void exitGame(ActionEvent event){
        Platform.exit();
    }

    @FXML
    void launcher(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wizard.fxml")));

        Stage secondStage = new Stage();
        secondStage.setTitle("Character Creator");
        secondStage.setScene(new Scene(root));
        secondStage.show();
    }
}
