package com.chris.acolatse.harrypotterJFX;


import com.chris.acolatse.harrypotterJFX.utils.TextAnimator;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import java.util.Objects;



public class HarryPotterJfxApp extends Application {

    @FXML
    TextAnimator textAnimator;
    @FXML
    private Text text;


    @Override
    public void init() throws Exception {
        System.out.println("Thread : " + Thread.currentThread().getName());
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Thread : " + Thread.currentThread().getName());
        System.out.println("getResource : " + getClass().getResource("/fxml/main.fxml"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/main.fxml")));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/main.css").toString());
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    // for eventually release ressources before quit the programm
    @Override
    public void stop() throws Exception {
        System.out.println("Thread : " + Thread.currentThread().getName());
    }

}