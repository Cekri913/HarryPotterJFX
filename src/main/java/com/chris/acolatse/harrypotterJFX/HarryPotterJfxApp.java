package com.chris.acolatse.harrypotterJFX;

import com.chris.acolatse.harrypotterJFX.entity.Pets;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



import java.util.Objects;



public class HarryPotterJfxApp extends Application {

    private Wizard wizard;
    @FXML


    @Override
    public void init() throws Exception {
        System.out.println("Thread : " + Thread.currentThread().getName());
        super.init();
        wizard = new Wizard("chrisaurel");
        wizard.setPet(Pets.CAT);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Thread : " + Thread.currentThread().getName());
        System.out.println("getResource : " + getClass().getResource("/fxml/main.fxml"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/main.fxml")));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/main.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle(wizard.getName());
        primaryStage.show();

    }


    // pour eventuellement liberer dees resources avant de quitter le programme
    @Override
    public void stop() throws Exception {
        System.out.println("Thread : " + Thread.currentThread().getName());
    }

    // Pas besoin
    /*public static void main(String[] args) {
        launch(args);
    }*/
}