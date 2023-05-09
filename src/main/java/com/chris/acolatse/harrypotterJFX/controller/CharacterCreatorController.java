// CharacterCreatorController.java
package com.chris.acolatse.harrypotterJFX.controller;

import java.util.Random;

import com.chris.acolatse.harrypotterJFX.entity.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
public class CharacterCreatorController {
    public RadioButton coreButton1;
    public RadioButton coreButton2;
    public RadioButton coreButton3;
    public RadioButton coreButton4;
    @FXML
    private TextField nameField;
    @FXML
    private Label houseValue;
    @FXML
    private ChoiceBox<String> animalChoice;
    @FXML
    private Button createButton;
    @FXML
    private Label resultLabel;
    @FXML
    private ToggleGroup coreGroup;

    @FXML
    private void initialize() {

        // Ajouter des éléments à la liste déroulante des animaux
        animalChoice.getItems().addAll("Chouette", "Chat", "Crapaud", "Rat");

        // Définir une valeur par défaut pour la liste déroulante des animaux
        animalChoice.getSelectionModel().selectFirst();

        // Ajouter un écouteur d'événements pour le bouton de création de personnage
        createButton.setOnAction(event -> createCharacter());
    }

    @FXML
    private void createCharacter() {
        // Récupérer les valeurs saisies par l'utilisateur
        String name = nameField.getText();
        String animal = animalChoice.getValue();
        RadioButton selectedCoreButton = (RadioButton) coreGroup.getSelectedToggle();
        String core = selectedCoreButton.getText();

        // Assigner une maison de manière aléatoire
        String[] houses = {"Gryffindor", "Hufflepuff", "Serdaigle", "Serpentard"};
        Random random = new Random();
        int index = random.nextInt(houses.length);
        String house = houses[index];

        // Créer un nouveau personnage avec les valeurs saisies
        Character character = new Character(name, animal, core, house);

        // Afficher les détails du personnage créé
        resultLabel.setText(character.toString());
    }
}
