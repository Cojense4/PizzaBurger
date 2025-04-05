package com.prog02.pizza_burger;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.prog02.pizza_burger.model.pizza.*;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.prog02.pizza_burger.App.*;

public class PizzaBuilderController implements Initializable {
    // Templates
    @FXML
    JFXComboBox<String> templateCombo;
    // Crusts
    @FXML
    JFXComboBox<String> crustCombo;
    JFXComboBox<String> crustSizeCombo;
    // Sauces
    @FXML
    JFXComboBox<String> sauceCombo1, sauceCombo2;
    @FXML
    JFXComboBox<String> sauceAmtCombo1, sauceAmtCombo2;
    //toppings
    @FXML
    JFXComboBox<String> chzCountCombo, chzCombo1, chzCombo2,
            meatCountCombo, meatCombo1, meatCombo2,
            vegCountCombo, vegCombo1, vegCombo2,
            extraCountCombo, extraCombo1, extraCombo2;
    @FXML
    JFXCheckBox chzDubChk1, chzDubChk2, 
            meatDubChk1, meatDubChk2, 
            vegDubChk1, vegDubChk2,
            extraDubChk1, extraDubChk2;
    @FXML
    HBox chzBox1, chzBox2,
            meatBox1, meatBox2,
            vegBox1, vegBox2,
            extraBox1, extraBox2;
    // Non-FXML variables
    Map<Integer, String> sauceAmtMap;
    Sauce exSauce = Sauce.TRADITIONAL;
    CartManager cartManager = CartManager.getInstance();
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (PizzaTemplate pizzaTemplate : PizzaTemplate.values()) {
            templateCombo.getItems().add(pizzaTemplate.name());
        }
        // Crusts
        for (Crust crust : Crust.values()) {
            crustCombo.getItems().add(crust.getName());
        }
        // Sauces
        for (Sauce sauce : Sauce.values()) {
            sauceCombo1.getItems().add(sauce.getName());
            sauceCombo2.getItems().add(sauce.getName());
        }
        sauceAmtMap = exSauce.getSauceMap();
        for (int x = 0; x < sauceAmtMap.size(); x++) {
            sauceAmtCombo1.getItems().add(sauceAmtMap.get(x));
            sauceAmtCombo2.getItems().add(sauceAmtMap.get(x));
        }
        // topping init
        for (Topping topping : Topping.values()) {
            if (Objects.equals(topping.getType(), "Cheese")) {
                chzCombo1.getItems().add(topping.getName());
                chzCombo2.getItems().add(topping.getName());
            } else if (Objects.equals(topping.getType(), "Veggie")) {
                vegCombo1.getItems().add(topping.getName());
                vegCombo2.getItems().add(topping.getName());
            } else if (Objects.equals(topping.getType(), "Meat")) {
                meatCombo1.getItems().add(topping.getName());
                meatCombo2.getItems().add(topping.getName());
            }
            extraCombo1.getItems().add(topping.getName());
            extraCombo2.getItems().add(topping.getName());

        }
    }
    
    @FXML
    protected void handleUseTemplate(ActionEvent event) {
        PizzaTemplate uTemplate = MenuItem.fromItemName(PizzaTemplate.class, templateCombo.getValue());
        if (uTemplate == null) return;

        // 1. Set crust selections
        Crust tCrust = uTemplate.getCrust();
        crustCombo.setValue(tCrust.getName());
        crustSizeCombo.setValue(tCrust.getSizeStr());

        // 2. Set Sauce details
        ArrayList<Sauce> tSauces = uTemplate.getSauces();
        if (!tSauces.isEmpty()) {
            Sauce s1 = tSauces.getFirst();
            sauceCombo1.setValue(s1.getName());
            sauceAmtCombo1.setValue(s1.getSauceStr());

            if (tSauces.size() >= 2) {
                Sauce s2 = tSauces.get(1);
                sauceCombo2.setValue(s2.getName());
                sauceAmtCombo2.setValue(s2.getSauceStr());
            }
        }

        // 3. Set Topping details for toppings slots
        ArrayList<Topping> tCheeses = uTemplate.getChzToppings();
        chzCountCombo.setValue(String.valueOf(tCheeses.size()));
        if (!tCheeses.isEmpty()) {
            Topping chz1 = tCheeses.getFirst();
            chzCombo1.setValue(chz1.getName());
            chzDubChk1.setSelected(chz1.isDouble());
            if (tCheeses.size() >= 2) {
                Topping chz2 = tCheeses.get(1);
                chzCombo2.setValue(chz2.getName());
                chzDubChk2.setSelected(chz2.isDouble());
                chzBox2.setVisible(true);
            }
        }
        ArrayList<Topping> tMeats = uTemplate.getMeatToppings();
        meatCountCombo.setValue(String.valueOf(tMeats.size()));
        if (!tMeats.isEmpty()) {
            Topping meat1 = tMeats.getFirst();
            meatCombo1.setValue(meat1.getName());
            meatDubChk1.setSelected(meat1.isDouble());
            if (tMeats.size() >= 2) {
                Topping meat2 = tMeats.get(1);
                meatCombo2.setValue(meat2.getName());
                meatDubChk2.setSelected(meat2.isDouble());
                meatBox2.setVisible(true);
            }
        }
        ArrayList<Topping> tVegs = uTemplate.getVegToppings();
        vegCountCombo.setValue(String.valueOf(tVegs.size()));
        if (!tVegs.isEmpty()) {
            Topping veg1 = tVegs.getFirst();
            vegCombo1.setValue(veg1.getName());
            vegDubChk1.setSelected(veg1.isDouble());
            if (tVegs.size() >= 2) {
                Topping veg2 = tVegs.get(1);
                vegCombo2.setValue(veg2.getName());
                vegDubChk2.setSelected(veg2.isDouble());
                vegBox2.setVisible(true);
            }
        }
        ArrayList<Topping> tExtras = uTemplate.getVegToppings();
        extraCountCombo.setValue(String.valueOf(tExtras.size()));
        if (!tExtras.isEmpty()) {
            Topping extra1 = tExtras.getFirst();
            extraCombo1.setValue(extra1.getName());
            extraDubChk1.setSelected(extra1.isDouble());
            if (tExtras.size() >= 2) {
                Topping extra2 = tExtras.get(1);
                extraCombo2.setValue(extra2.getName());
                extraDubChk2.setSelected(extra2.isDouble());
                extraBox2.setVisible(true);
            }
        }
    }

    // Need to add topping change logic
//    protected void handleToppingAmtChange(ActionEvent event) {}

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
// Need to fix makePizza() logic
    private Pizza makePizza() {return PizzaTemplate.CHEESE.toPizza("Cheese Pizza");}
//    private Pizza makePizza() {
//        //init pizza vars
//        Crust uCrust = MenuItem.fromItemName(Crust.class, crustCombo.getValue());
//        ArrayList<Sauce> uSauces = new ArrayList<>();
//        uSauces.add(MenuItem.fromItemName(Sauce.class, sauceCombo1.getValue()));
//        ArrayList<Topping> uTopping = new ArrayList<>();
//
//        // sauce processing
//        String sauceAmtVal = sauceAmtCombo1.getValue();
//        int sauceAmt = 2;
//        if (sauceAmtVal != null && !sauceAmtVal.isEmpty()) {
//            try {
//                sauceAmt = keyFromVal(sauceAmtMap, sauceAmtVal);
//            } catch (NumberFormatException e) {
//                // Log error or set a default value if the format is unexpected
//            }
//        }
//
//        // Topping Processing
//        List<String> toppingTypes = Arrays.asList(
//                chzCombo1.getValue(),   // Cheese
//                vegCombo1.getValue(),   // Veggie
//                meatCombo1.getValue(),  // Meat
//                extraCombo1.getValue()  // Extra
//        );
//
//        List<Boolean> toppingDoubles = Arrays.asList(
//                chzDubChk1.isSelected(),  // Double Topping?
//                vegDubChk1.isSelected(),    // Double Veggie?
//                meatDubChk1.isSelected(),   // Double Meat?
//                extraDubChk1.isSelected()   // Double Extra?
//        );
//
//        for (int i = 0; i < toppingTypes.size(); i++) {
//            String toppingType = toppingTypes.get(i);
//            if (toppingType != null && !toppingType.isEmpty()) {
//                // Add topping once
//                uTopping.add(MenuItem.fromItemName(Topping.class, toppingType));
//                // If doubling is enabled, add it a second time
//                if (toppingDoubles.get(i)) {
//                    uTopping.add(MenuItem.fromItemName(Topping.class, toppingType));
//                }
//            }
//        }
//        return new Pizza(uCrust, uSauces, uTopping);
//    }

    private int keyFromVal(Map < Integer, String > uMap, String sVal){
        for (Map.Entry<Integer, String> entry : uMap.entrySet()) {
            if (entry.getValue().equals(sVal)) {
                return entry.getKey();
            }
        }
        return 2;
    }
}