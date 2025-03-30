package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.user.User;
import com.prog02.pizza_burger.model.user.UserStorage;
import javafx.fxml.FXML;
import java.io.IOException;


public class HomeController {

    @FXML
    private void handleBurgerBuilder() throws IOException {
        // This method is triggered when the "Start Order" button is pressed.
        App.setRoot("BurgerBuilder");
    }
    @FXML
    private void handlePizzaBuilder() throws IOException {
        // This method is triggered when the "Start Order" button is pressed.
        App.setRoot("PizzaBuilder");
    }
    @FXML
    private void handleGoToCart() throws IOException {
        // This method is triggered when the "Start Order" button is pressed.
        App.setRoot("Cart");
    }
}