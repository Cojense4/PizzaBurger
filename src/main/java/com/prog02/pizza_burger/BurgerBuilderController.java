package com.prog02.pizza_burger;

import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.ComboBox;
import com.prog02.pizza_burger.model.burger.Buns;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class BurgerBuilderController implements Initializable {

    @FXML
    ComboBox<String> bunCombo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (Buns bun : Buns.values()) {
            bunCombo.getItems().add(bun.getName());
        }
    }

    @FXML
    protected void handleGoToCart() {

    }

}
