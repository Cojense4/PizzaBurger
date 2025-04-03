package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.prog02.pizza_burger.App.*;

public class ShopCartController implements Initializable {
    @FXML
    private JFXTextArea DisplayArea;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StringBuilder Reciept = new StringBuilder();
        CartManager cartManager = CartManager.getInstance();
        double totalPrice = 0;

        for (MenuItem item : cartManager.getCartItems()) {
            Reciept.append(item.display());
            totalPrice += item.getPrice();
        }
        DisplayArea.setText(Reciept + String.format("----------($%.2f)----------", totalPrice));
    }

    @FXML
    protected void handleCheckOut() throws IOException {
        setRoot("Completed.fxml");
    }

    @FXML
    protected void handleAddItem() throws IOException {
        setRoot("Main.fxml");
    }
}