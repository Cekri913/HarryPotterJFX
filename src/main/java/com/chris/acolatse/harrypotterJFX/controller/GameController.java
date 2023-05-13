package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Enemy;
import com.chris.acolatse.harrypotterJFX.entity.GameLogic;
import com.chris.acolatse.harrypotterJFX.entity.Level;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class GameController {
    Wizard wizard;

    public void startGame(ActionEvent actionEvent){
        GameLogic gameLogic = new GameLogic();

        Enemy troll = new Enemy("Troll", 30);
        Level level1 = new Level(1, troll, "The Philosopher's stone" );
        level1.start();
        GameLogic.fight(wizard, troll, level1);
        level1.end(wizard, troll);
    }

    public void Quit(ActionEvent event){
        Platform.exit();
    }

    public void Attack(ActionEvent event) {
    }

    public void Defend(ActionEvent event) {
    }
}
