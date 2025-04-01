package com.prog02.pizza_burger;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.prog02.pizza_burger.model.pizza.*;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PizzaBuilderController implements Initializable {
    // crust
    @FXML
    JFXComboBox<String> crustCombo;
    // sauce
    @FXML
    JFXComboBox<String> sauceCombo;
    @FXML
    JFXComboBox<String> sauceAmtCombo;
    //toppings
    @FXML
    JFXComboBox<String> chzCombo;
    @FXML
    JFXCheckBox chzDoubleChk;
    @FXML
    JFXComboBox<String> meatCombo;
    @FXML
    JFXCheckBox meatDoubleChk;
    @FXML
    JFXComboBox<String> vegCombo;
    @FXML
    JFXCheckBox vegDoubleChk;
    @FXML
    JFXComboBox<String> extraCombo;
    @FXML
    JFXCheckBox extraDoubleChk;
    // Non-FXML variables
    Map<Integer, String> sauceAmtMap;
    ArrayList<Pizza> burgerCart;
    CartManager cartManager = CartManager.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // crust init
        for (Crust crust : Crust.values()) {
            crustCombo.getItems().add(crust.getName());
        }
        // sauce init
        for (Sauce sauce : Sauce.values()) {
            sauceCombo.getItems().add(sauce.getName());
        }
        sauceAmtMap = new HashMap<>();
        sauceAmtMap.put(0, "No Sauce");
        sauceAmtMap.put(1, "Light Sauce");
        sauceAmtMap.put(2, "Normal Sauce");
        sauceAmtMap.put(3, "Extra Sauce");
        for (String amt : sauceAmtMap.values()){
            sauceAmtCombo.getItems().add(amt);
        }
        // topping init
        for (Topping topping : Topping.values()) {
            System.out.println(topping + topping.getType());
        }
    }
    
    @FXML
    protected void handleAddToCart() {
        Pizza newPiz = makePizza();
        cartManager.addItem((MenuItem)newPiz);
        for (MenuItem item : cartManager.getCartItems()) {
            item.display();
        }
    }

    @FXML
    protected void handlePayNow() {
        Pizza newPiz = makePizza();
        cartManager.addItem((MenuItem)newPiz);
        newPiz.display();
    }

    private Pizza makePizza() {
        //init pizza vars
        Crust uCrust = MenuItem.fromItemName(Crust.class, crustCombo.getValue());
        Sauce uSauce = MenuItem.fromItemName(Sauce.class, sauceCombo.getValue());
        ArrayList<Topping> uTopping = new ArrayList<>();

        // sauce processing
        String sauceAmtVal = sauceAmtCombo.getValue();
        int sauceAmt = 2;
        if (sauceAmtVal != null && !sauceAmtVal.isEmpty()) {
            try {
                sauceAmt = keyFromVal(sauceAmtMap, sauceAmtVal);
            } catch (NumberFormatException e) {
                // Log error or set a default value if the format is unexpected
            }
        }

        // topping processing
        uTopping.add(Topping.GRUYERE);
        // Topping Processing
        return new Pizza(uCrust, uSauce, uTopping);
    }

    private int keyFromVal(Map < Integer, String > uMap, String sVal){
        for (Map.Entry<Integer, String> entry : uMap.entrySet()) {
            if (entry.getValue().equals(sVal)) {
                return entry.getKey();
            }
        }
        return 2;
    }
}