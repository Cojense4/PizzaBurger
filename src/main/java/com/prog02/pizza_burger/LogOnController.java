package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.user.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class LogOnController {

    @FXML   
    private TextArea logOnTextArea;

    @FXML
    private void initialize() {
        User currentUser = UserStorage.getCurrentUser();
        if (currentUser != null) {
            logOnTextArea.setText("Welcome, " + currentUser.getName() + "!");
        } else {
            logOnTextArea.setText("No user logged in.");
        }
    }

    @FXML
    private void logOut() throws IOException {
        // Implement the logic to go back to the sign-in page
        App.setRoot("SignIn");
    }
}