package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.user.User;
import com.prog02.pizza_burger.model.user.UserStorage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleBackToSignIn() throws IOException {
        App.setRoot("SignIn");
    }

    @FXML
    private void handleSignUp() throws IOException {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        
        if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
            showAlert(AlertType.ERROR, "All fields are required.");
            return;
        }
        
        User newUser = new User(name, phone, email, password);
        UserStorage.addUser(newUser);
        
        App.setRoot("SignIn");
    }

    private void showAlert(AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.show();
    }
}