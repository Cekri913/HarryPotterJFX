package com.chris.acolatse.harrypotterJFX.entity;
import lombok.Getter;

public enum Core {
    PHOENIX_FEATHER(1), DRAGON_HEARTSTRINGS(2), BASIL_HORN(3), TROLL_MUSTACHE(4);

    @Getter
    private final int coreIndice;
     Core(int indice){
         this.coreIndice=indice;
     }
}
