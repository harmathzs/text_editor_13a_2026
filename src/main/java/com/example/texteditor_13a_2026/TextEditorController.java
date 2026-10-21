package com.example.texteditor_13a_2026;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class TextEditorController {
    @FXML public TextArea textArea;

    public String filename;
    public String filepath;

    public static boolean isRunningTest = false;

    public void handleNewMenuClick(ActionEvent actionEvent) {
        // TODO - unsaved previous text?
        if (!isRunningTest) textArea.setText("");
    }

    public void handleOpenMenuClick(ActionEvent actionEvent) throws IOException {
        FileChooser openDialog = new FileChooser();
        openDialog.setTitle("Open file ...");
        openDialog.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("All files", "*.*"));
        File file = openDialog.showOpenDialog(TextEditorApplication.scene.getWindow());
        if (file.exists()) {
            filename = file.getName();
            filepath = file.getPath();
            System.out.println("filepath: "+filepath);
            System.out.println("filename: "+filename);

            String content = Files.readString(file.toPath());
            textArea.setText(content);
        }
    }

    public void handleSaveMenuClick(ActionEvent actionEvent) {

    }

    public void handleSaveAsMenuClick(ActionEvent actionEvent) {

    }

    public void handleExitMenuClick(ActionEvent actionEvent) {
        Platform.exit();
    }
}