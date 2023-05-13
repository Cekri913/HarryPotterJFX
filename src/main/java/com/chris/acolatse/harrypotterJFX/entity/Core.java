package com.chris.acolatse.harrypotterJFX.entity;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableMap;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import lombok.Getter;

public enum Core implements Toggle {
    PHOENIX_FEATHER(1), DRAGON_HEARTSTRINGS(2), BASIL_HORN(3), TROLL_MUSTACHE(4);

    @Getter
    private final int coreIndice;
     Core(int indice){
         this.coreIndice=indice;
     }

    @Override
    public ToggleGroup getToggleGroup() {
        return null;
    }

    @Override
    public void setToggleGroup(ToggleGroup toggleGroup) {

    }

    @Override
    public ObjectProperty<ToggleGroup> toggleGroupProperty() {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void setSelected(boolean selected) {

    }

    @Override
    public BooleanProperty selectedProperty() {
        return null;
    }

    @Override
    public Object getUserData() {
        return null;
    }

    @Override
    public void setUserData(Object value) {

    }

    @Override
    public ObservableMap<Object, Object> getProperties() {
        return null;
    }
}
