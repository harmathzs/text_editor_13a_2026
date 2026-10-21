package com.example.texteditor_13a_2026;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TextEditorTest {
    @Before
    public void testBefore() {
        TextEditorApplication.isRunningTest = true;
        TextEditorController.isRunningTest = true;
    }

    @After
    public void testAfter() {
        TextEditorApplication.isRunningTest = false;
        TextEditorController.isRunningTest = false;
    }

    @Test
    public void testApp() throws IOException {
        TextEditorApplication.main(null);
        TextEditorApplication app = new TextEditorApplication();
        app.start(null);
    }

    @Test
    public void testNew() {
        TextEditorController controller = new TextEditorController();
        controller.handleNewMenuClick(null);
    }

    @Test
    public void testOpen() throws IOException {
        TextEditorController controller = new TextEditorController();
        controller.handleOpenMenuClick(null);
    }

    @Test
    public void testExit() {
        TextEditorController controller = new TextEditorController();
        controller.handleExitMenuClick(null);
    }
}
