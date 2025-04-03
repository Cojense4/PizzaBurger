package com.prog02.pizza_burger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    protected void handleMakeBurg() throws IOException {
        App.setRoot("BurgerBuilder.fxml");
    }

    @FXML
    protected void handleMakePiz() throws IOException {
        App.setRoot("PizzaBuilder.fxml");
    }
}