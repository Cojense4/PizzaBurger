package com.prog02.pizza_burger;

import com.jfoenix.controls.JFXTextArea;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.prog02.pizza_burger.App.*;

public class CompletedController implements Initializable {
    @FXML
    private JFXTextArea DisplayArea;
    CartManager cartManager = CartManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        double totalPrice = 0.00;
        StringBuilder Receipt = new StringBuilder();
        int burgCount = 0;
        int pizCount = 0;

        Receipt.append("------- Final Receipt ------- \n");
        for (MenuItem item : cartManager.getCartItems()) {
            String itemClass = item.getClass().getSimpleName();
            if (itemClass.equals("Pizza")) {
                pizCount++;
                Receipt.append(String.format("%s #%d -- ($%.2f) \n", itemClass, pizCount, item.getPrice()));
            } else if (itemClass.equals("Burger")) {
                burgCount++;
                Receipt.append(String.format("%s #%d -- ($%.2f) \n", itemClass, burgCount, item.getPrice()));
            }
            totalPrice += item.getPrice();
        }
        DisplayArea.setText(Receipt + String.format("-------- ($%.2f) --------", totalPrice));
    }

    @FXML
    protected void handleStartOver() throws IOException {
        cartManager.clearCart();
        setRoot("Main.fxml");
    }
}