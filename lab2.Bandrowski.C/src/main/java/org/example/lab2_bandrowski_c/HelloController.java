package org.example.lab2_bandrowski_c;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void total() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}