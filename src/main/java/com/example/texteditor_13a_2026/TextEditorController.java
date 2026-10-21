package com.example.texteditor_13a_2026;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextEditorController {
    @FXML public TextArea textArea;
    @FXML public MenuItem saveMenuItem;

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
        File file = null;
        if (!isRunningTest) file = openDialog.showOpenDialog(TextEditorApplication.scene.getWindow());
        if (isRunningTest || (!isRunningTest && file!=null && file.exists()) ) {
            if (!isRunningTest) filename = file.getName();
            if (!isRunningTest) filepath = file.getPath();
            //System.out.println("filepath: "+filepath);
            //System.out.println("filename: "+filename);
            String content = null;
            if (!isRunningTest) content = Files.readString(file.toPath());
            if (!isRunningTest) textArea.setText(content);
        }
    }

    public void handleSaveMenuClick(ActionEvent actionEvent) throws IOException {
        // TODO - disable/enable save menu item if filepath is/not null
        if (!isRunningTest) Files.writeString(Path.of(filepath), textArea.getText());
    }

    public void handleSaveAsMenuClick(ActionEvent actionEvent) throws IOException {
        FileChooser saveDialog = new FileChooser();
        saveDialog.setTitle("Save as ...");
        saveDialog.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("All files", "*.*"));
        File file = null;
        if (!isRunningTest) file = saveDialog.showSaveDialog(TextEditorApplication.scene.getWindow());
        if (!isRunningTest && file!=null) {
            filename = file.getName();
            filepath = file.getPath();
            System.out.println("filepath: "+filepath);
            System.out.println("filename: "+filename);

            Files.writeString(Path.of(filepath), textArea.getText());
        }
    }

    public void handleExitMenuClick(ActionEvent actionEvent) {
        Platform.exit();
    }
}