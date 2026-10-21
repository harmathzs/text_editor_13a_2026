package com.example.texteditor_13a_2026;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TextEditorController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}