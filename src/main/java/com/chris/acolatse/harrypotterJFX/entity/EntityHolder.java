package com.chris.acolatse.harrypotterJFX.entity;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.time.temporal.ValueRange;
import java.util.Objects;

public final class EntityHolder {
    @Getter @Setter
    private Wizard wizard;

    @Getter @Setter
    private Core core;

    @Getter
    private Pets pet;

    @Getter @Setter
    private Parent startRoot;

    @Getter @Setter
    private Parent wizardRoot;

    @Setter @Getter
    private Parent petRoot;

    @Getter @Setter
    private Parent coreRoot;

    @Getter @Setter
    private Parent recapRoot;

    @Getter @Setter
    private Parent gameRoot;

    @Getter @Setter
    private Parent championRoot;

    @Getter @Setter
    private Stage startStage;

    @Getter @Setter
    private Stage wizardStage;

    @Getter @Setter
    private Stage coreStage;

    @Getter @Setter
    private Stage petStage;

    @Getter @Setter
    private Stage recapStage;

    @Getter @Setter
    private Stage gameStage;

    @Getter @Setter
    private Stage championStage;

    @Getter @Setter
    private Level level1;

    @Getter @Setter
    private Level level2;

    @Getter @Setter
    private Level level3;

    @Getter @Setter
    private Level level4;

    @Getter @Setter
    private Level level5;

    @Getter @Setter
    private Level level6;

    @Getter @Setter
    private Level level7;

    @Getter @Setter
    private int levelId;

    @Getter
    private Level currentLevel;

    public void setPet(Pets pet){
        this.pet=pet;
        this.wizard.setPet(pet);
    }



    public void setCurrentLevel() {
        Level [] levels = {level1, level2, level3, level4, level5, level6, level7} ;
        final ValueRange range = ValueRange.of(1, levels.length);
        System.out.println("level range  : " + range);
        if(range.isValidIntValue(levelId)) {
            this.currentLevel = levels[levelId - 1];
        }
    }


    private final static EntityHolder INSTANCE = new EntityHolder();

    private EntityHolder() {}

    public static EntityHolder getInstance() {
        return INSTANCE;
    }

}
