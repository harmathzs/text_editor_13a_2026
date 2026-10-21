package com.example.texteditor_13a_2026;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TextEditorController {
    @FXML public TextArea textArea;

    public void handleNewMenuClick(ActionEvent actionEvent) {

    }

    public void handleOpenMenuClick(ActionEvent actionEvent) {

    }

    public void handleSaveMenuClick(ActionEvent actionEvent) {

    }

    public void handleSaveAsMenuClick(ActionEvent actionEvent) {

    }

    public void handleExitMenuClick(ActionEvent actionEvent) {
        Platform.exit();
    }
}