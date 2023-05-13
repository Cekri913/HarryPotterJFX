package com.chris.acolatse.harrypotterJFX.entity;

import javafx.scene.Parent;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public final class EntityHolder {
    @Getter @Setter
    private Wizard wizard;

    @Getter @Setter
    private Core core;

    @Getter @Setter
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

    private final static EntityHolder INSTANCE = new EntityHolder();

    private EntityHolder() {}

    public static EntityHolder getInstance() {
        return INSTANCE;
    }

}
