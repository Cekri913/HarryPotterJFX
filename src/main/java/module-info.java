module com.chris.acolatse.harrypotterJFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens com.chris.acolatse.harrypotterJFX to javafx.fxml;
    exports com.chris.acolatse.harrypotterJFX;

    opens com.chris.acolatse.harrypotterJFX.controller to javafx.fxml;
    exports com.chris.acolatse.harrypotterJFX.controller;

    opens com.chris.acolatse.harrypotterJFX.utils to javafx.fxml;
    exports com.chris.acolatse.harrypotterJFX.utils;
    exports com.chris.acolatse.harrypotterJFX.entity;
    opens com.chris.acolatse.harrypotterJFX.entity to javafx.fxml;
}