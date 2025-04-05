package com.prog02.pizza_burger;

import com.jfoenix.controls.JFXTextArea;
import com.prog02.pizza_burger.model.burger.Burger;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.prog02.pizza_burger.App.setRoot;

public class ShopCartPaneController implements Initializable {
    @FXML
    private JFXTextArea burgCartArea;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StringBuilder Reciept = new StringBuilder();
        CartManager cartManager = CartManager.getInstance();
        double totalPrice = 0;

        for (MenuItem item : cartManager.getCartItems()) {
            Reciept.append(item.display());
            totalPrice += item.getPrice();
        }
        burgCartArea.setText(Reciept + String.format("----------($%.2f)----------", totalPrice));
    }
}