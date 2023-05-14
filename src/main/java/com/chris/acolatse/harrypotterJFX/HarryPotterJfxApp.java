package com.chris.acolatse.harrypotterJFX;


import com.chris.acolatse.harrypotterJFX.entity.Enemy;
import com.chris.acolatse.harrypotterJFX.entity.EntityHolder;
import com.chris.acolatse.harrypotterJFX.entity.Level;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import com.chris.acolatse.harrypotterJFX.utils.Constant;
import com.chris.acolatse.harrypotterJFX.utils.TextAnimator;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import java.util.Objects;
import java.util.Scanner;


public class HarryPotterJfxApp extends Application {

    @FXML
    TextAnimator textAnimator;
    @FXML
    private Text text;

    EntityHolder holder = EntityHolder.getInstance();


    @Override
    public void init() throws Exception {
        super.init();
        holder.setStartRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/main.fxml"))));
        holder.setWizardRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wizard.fxml"))));
        holder.setCoreRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/core.fxml"))));
        holder.setPetRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/pet.fxml"))));
        holder.setRecapRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/recap.fxml"))));
        holder.setGameRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml"))));
        holder.setChampionRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/champion.fxml"))));
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Thread : " + Thread.currentThread().getName());
        System.out.println("getResource : " + getClass().getResource("/fxml/main.fxml"));
        Parent currentRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/main.fxml")));
        holder.setStartRoot(currentRoot);
        Scene scene = new Scene(holder.getStartRoot());
        scene.getStylesheets().add(getClass().getResource("/css/main.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("HARRY POTTER AT HOME !");
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/app_icon.png"))));
        primaryStage.show();
        holder.setStartStage(primaryStage);
    }


    // for eventually release ressources before quit the programm
    @Override
    public void stop() throws Exception {
        System.out.println("Thread : " + Thread.currentThread().getName());
    }

}