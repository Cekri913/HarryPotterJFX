package com.chris.acolatse.harrypotterJFX.controller;

import com.chris.acolatse.harrypotterJFX.entity.Enemy;
import com.chris.acolatse.harrypotterJFX.entity.GameLogic;
import com.chris.acolatse.harrypotterJFX.entity.Level;
import com.chris.acolatse.harrypotterJFX.entity.Wizard;

public class GameController {
    Wizard wizard;

    public void startGame(){
        GameLogic gameLogic = new GameLogic();
        Enemy troll = new Enemy("Troll", 30);
        Level level1 = new Level(1, troll, "The Philosopher's stone" );
        level1.start();
        GameLogic.fight(wizard, troll, level1);
        level1.end(wizard, troll);





    }
}
