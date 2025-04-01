package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.burger.*;

import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.common.Priceable;
import com.prog02.pizza_burger.model.user.CartManager;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;


import java.util.ArrayList;
import java.util.Map;

public class BurgerBuilderController implements Initializable {
    // buns
    @FXML
    JFXComboBox<String> bunCombo;
    @FXML
    JFXCheckBox toastedCheck;
    // patties
    @FXML
    JFXComboBox<String> pattyTypeCombo;
    @FXML
    JFXComboBox<String> pattySeasonCombo;
    @FXML
    JFXComboBox<String> pattyAmtCombo;
    @FXML
    JFXSlider cookSlider;
    //cheese
    @FXML
    JFXComboBox<String> chzTypeCombo;
    @FXML
    JFXComboBox<String> chzAmtCombo;
    @FXML
    JFXCheckBox smokedCheck;
    @FXML
    JFXCheckBox agedCheck;
    @FXML
    JFXCheckBox lettuceChk;
    @FXML
    JFXCheckBox avacadoChk;
    @FXML
    JFXCheckBox onionChk;
    @FXML
    JFXCheckBox tomatoChk;
    @FXML
    JFXCheckBox pickleChk;
    @FXML
    JFXCheckBox mushroomChk;
    @FXML
    JFXCheckBox baconChk;
    @FXML
    JFXCheckBox cookOnionChk;
    // Non-FXML variables
    Map<Integer, String> seasoningMap;
    ArrayList<Burger> burgerCart;
    CartManager cartManager = CartManager.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // bun init
        for (Bun bun : Bun.values()) {
            bunCombo.getItems().add(bun.getName());
        }
        // patty init

        for (Patty patty : Patty.values()) {
            pattyTypeCombo.getItems().add(patty.getName());
        }
        seasoningMap = new HashMap<>();
        seasoningMap.put(0, "No Seasonings");
        seasoningMap.put(1, "Light Seasonings");
        seasoningMap.put(2, "Normal Seasonings");
        seasoningMap.put(3, "Extra Seasonings");
        for (String amt : seasoningMap.values()){
            pattySeasonCombo.getItems().add(amt);
        }
        for (int i = 1; i < 5; i++) {
            pattyAmtCombo.getItems().add(i + "x");
        }
        // cheese init
        for (Cheese cheese : Cheese.values()) {
            chzTypeCombo.getItems().add(cheese.getName());
        }
        for (int i = 1; i < 3; i++) {
            chzAmtCombo.getItems().add(Integer.toString(i) + "x");
        }
    }

    @FXML
    protected void handleAddToCart() {
        Burger newBurg = makeBurger();
        cartManager.addItem(newBurg);
        for (MenuItem item : cartManager.getCartItems()) {
            item.display();
        }
    }

    @FXML
    protected void handlePayNow() {
        Burger newBurg = makeBurger();
        cartManager.addItem(newBurg);
        newBurg.display();
    }

    private Burger makeBurger() {
        Bun uBun = MenuItem.fromItemName(Bun.class, bunCombo.getValue());
        ArrayList<Patty> uPatties = new ArrayList<>();
        ArrayList<Cheese> uCheeses = new ArrayList<>();
        ArrayList<Garnish> uGarnish = new ArrayList<>();

        // Bun Process
        uBun.setIsToasted(toastedCheck.isSelected());
        // Patty Process
        Patty pat = MenuItem.fromItemName(Patty.class, pattyTypeCombo.getValue());
        // Provide a default value if the combo box value is null or empty
        String pattyAmtValue = pattyAmtCombo.getValue();
        int patAmt = 1; // default value
        if (pattyAmtValue != null && !pattyAmtValue.isEmpty()) {
            try {
                patAmt = Integer.parseInt(pattyAmtValue.substring(0, 1));
            } catch (NumberFormatException e) {
                // Log error or set a default value if the format is unexpected
            }
        }
        int uCookLevel = (int) cookSlider.getValue();
        int uPattySeason = keyFromVal(seasoningMap, pattySeasonCombo.getValue());
        pat.customizePatty(uCookLevel, uPattySeason);
        for (int i = 0; i < patAmt; i++) {
            uPatties.add(pat);
        }
        // Cheese Process
        Cheese chz = MenuItem.fromItemName(Cheese.class, chzTypeCombo.getValue());
        boolean smoked = smokedCheck.isSelected();
        boolean aged = agedCheck.isSelected();
        chz.customizeCheese(smoked, aged);
        String chzAmtVal = chzAmtCombo.getValue();
        int chzAmt = 1;
        if (chzAmtVal != null && !chzAmtVal.isEmpty()) {
            try {
                chzAmt = Integer.parseInt(chzAmtVal.substring(0, 1));
            } catch (NumberFormatException e) {
                // Log error or set a default value if the format is unexpected
            }
        }
        for (int i = 0; i < chzAmt * patAmt; i++) {
            uCheeses.add(chz);
        }
        // Garnish Process
        if (tomatoChk.isSelected()) {
            uGarnish.add(Garnish.TOMATO);
        }
        if (lettuceChk.isSelected()) {
            uGarnish.add(Garnish.LETTUCE);
        }
        if (avacadoChk.isSelected()) {
            uGarnish.add(Garnish.AVACADO);
        }
        if (pickleChk.isSelected()) {
            uGarnish.add(Garnish.PICKLES);
        }
        if (onionChk.isSelected()) {
            uGarnish.add(Garnish.ONION);
        }
        if (mushroomChk.isSelected()) {
            uGarnish.add(Garnish.MUSHROOMS);
        }
        if (baconChk.isSelected()) {
            uGarnish.add(Garnish.BACON);
        }
        if (cookOnionChk.isSelected()) {
            uGarnish.add(Garnish.COOKED_ONION);
        }
        return new Burger(uBun, uPatties, uCheeses, uGarnish);
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