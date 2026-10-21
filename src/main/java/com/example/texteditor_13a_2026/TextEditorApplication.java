package com.example.texteditor_13a_2026;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TextEditorApplication extends Application {
    public static boolean isRunningTest = false;

    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = null;
        if (!isRunningTest) fxmlLoader = new FXMLLoader(TextEditorApplication.class.getResource("text-editor-view.fxml"));
        scene = null;
        if (!isRunningTest) scene = new Scene(fxmlLoader.load(), 800, 600);
        if (!isRunningTest) stage.setTitle("My Text Editor v0.1 by Zsolt Harmath");
        if (!isRunningTest) stage.setScene(scene);
        if (!isRunningTest) stage.show();
    }

    public static void main(String[] args) {
        if (!isRunningTest) launch();
    }
}