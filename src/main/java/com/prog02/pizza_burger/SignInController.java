package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.user.User;
import com.prog02.pizza_burger.model.user.UserStorage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignInController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    @FXML
    private void handleSignIn() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please fill in Username and Password.");
            return;
        }

        User authenticatedUser = UserStorage.authenticateUser(username, password);
        if (authenticatedUser == null) {
            errorLabel.setText("Invalid Username or Password.");
            return;
        }

        UserStorage.setCurrentUser(authenticatedUser);
        App.setRoot("LogOn");
    }

    @FXML
    private void handleSignUp() throws IOException {
        App.setRoot("SignUp");
    }
}
