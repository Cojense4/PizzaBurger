package com.prog02.pizza_burger;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.prog02.pizza_burger.model.pizza.*;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.prog02.pizza_burger.App.*;

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
            if (Objects.equals(topping.getType(), "Cheese")) {
                chzCombo.getItems().add(topping.getName());
                extraCombo.getItems().add(topping.getName());
            } else if (Objects.equals(topping.getType(), "Veggie")) {
                vegCombo.getItems().add(topping.getName());
                extraCombo.getItems().add(topping.getName());
            } else if (Objects.equals(topping.getType(), "Meat")) {
                meatCombo.getItems().add(topping.getName());
                extraCombo.getItems().add(topping.getName());
            }
        }
    }
    
    @FXML
    protected void handleAddToCart() throws IOException {
        Pizza newPiz = makePizza();
        cartManager.addItem(newPiz);
        setRoot("Main.fxml");
    }

    @FXML
    protected void handlePayNow() throws IOException {
        Pizza newPiz = makePizza();
        cartManager.addItem(newPiz);
        setRoot("ShopCart.fxml");
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

        // Topping Processing
        List<String> toppingTypes = Arrays.asList(
                chzCombo.getValue(),   // Cheese
                vegCombo.getValue(),   // Veggie
                meatCombo.getValue(),  // Meat
                extraCombo.getValue()  // Extra
        );

        List<Boolean> toppingDoubles = Arrays.asList(
                chzDoubleChk.isSelected(),  // Double Cheese?
                vegDoubleChk.isSelected(),    // Double Veggie?
                meatDoubleChk.isSelected(),   // Double Meat?
                extraDoubleChk.isSelected()   // Double Extra?
        );

        for (int i = 0; i < toppingTypes.size(); i++) {
            String toppingType = toppingTypes.get(i);
            if (toppingType != null && !toppingType.isEmpty()) {
                // Add topping once
                uTopping.add(MenuItem.fromItemName(Topping.class, toppingType));
                // If doubling is enabled, add it a second time
                if (toppingDoubles.get(i)) {
                    uTopping.add(MenuItem.fromItemName(Topping.class, toppingType));
                }
            }
        }
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