package com.chris.acolatse.harrypotterJFX.entity;

import lombok.Getter;
import lombok.Setter;

public final class UserHolder {
    @Getter @Setter
    private Wizard wizard;

    @Getter @Setter
    private Core core;
    private final static UserHolder INSTANCE = new UserHolder();

    private UserHolder() {}

    public static UserHolder getInstance() {
        return INSTANCE;
    }

}
