package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.burger.*;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;

import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Map;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;

import static com.prog02.pizza_burger.App.*;

public class BurgerBuilderController implements Initializable {
    // templates
    @FXML
    JFXComboBox<String> templateCombo;
    // buns
    @FXML
    JFXComboBox<String> bunCombo;
    @FXML
    JFXCheckBox toastedCheck;

    // patties
    @FXML
    JFXComboBox<String> pattyTypeCombo, pattySeasonCombo, pattyAmtCombo;
    @FXML
    JFXSlider cookSlider;

    //cheese
    @FXML
    JFXComboBox<String> chzTypeCombo, chzAmtCombo;
    @FXML
    JFXCheckBox smokedCheck, agedCheck;
    // Garnishes
    @FXML
    JFXCheckBox lettuceChk, avacadoChk, onionChk, tomatoChk, pickleChk, mushroomChk, baconChk, cookOnionChk;
    // Non-FXML variables
    Map<Integer, String> seasoningMap;
    CartManager cartManager = CartManager.getInstance();
    Patty exPatty = Patty.BEEF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (BurgerTemplate burgTemp : BurgerTemplate.values()) {
            templateCombo.getItems().add(burgTemp.getName());
        }
        // bun init
        for (Bun bun : Bun.values()) {
            bunCombo.getItems().add(bun.getName());
        }
        // patty init

        for (Patty patty : Patty.values()) {
            pattyTypeCombo.getItems().add(patty.getName());
        }

        for (int x = 1; x < 5; x++) {
            String season = exPatty.getSeasoning(x);
            seasoningMap = new HashMap<>();
            seasoningMap.put(x, season);
            pattySeasonCombo.getItems().add(season);
        }
        for (int i = 1; i < 5; i++) {
            pattyAmtCombo.getItems().add(i + "x");
        }
        // cheese init
        for (Cheese cheese : Cheese.values()) {
            chzTypeCombo.getItems().add(cheese.getName());
        }
        for (int i = 1; i < 3; i++) {
            chzAmtCombo.getItems().add(i + "x");
        }
    }

    @FXML
    protected void handleUseTemplate() {
        BurgerTemplate fromTemplate = MenuItem.fromItemName(BurgerTemplate.class, templateCombo.getValue());
        if (fromTemplate == null) return;
        // 1. Set bun selection
        bunCombo.setValue(fromTemplate.getBun().getName());

        // 2. Set patty count (number of patties) and update patty/cheese sections visibility
        int pattyCount = fromTemplate.getPatties().size();
        pattyAmtCombo.setValue(String.format("%dx",pattyCount));
        // If pattyCountCombo onAction is not automatically updating the UI, call update method manually:
        updatePattyAndCheeseSections(pattyCount);

        // 3. Set patty details for each patty slot
        List<Patty> templatePatties = fromTemplate.getPatties();
        if (pattyCount >= 1) {
            Patty p1 = templatePatties.getFirst();
            pattyTypeCombo.setValue(p1.getName());
            pattySeasonCombo.setValue(p1.getSeasoning());
            // Set cook level slider - assuming slider values map to CookLevel ordinal
            cookSlider.setValue(p1.getCookInt());
        }
//        if (pattyCount >= 2) {
//            Patty p2 = templatePatties.get(1);
//            patty2Type.setValue(p2.getType());
//            patty2Seasoning.setValue(p2.getSeasoning());
//            patty2Cook.setValue(p2.getCookLevel().ordinal());
//        }
//        if (pattyCount >= 3) {
//            Patty p3 = templatePatties.get(2);
//            patty3Type.setValue(p3.getType());
//            patty3Seasoning.setValue(p3.getSeasoning());
//            patty3Cook.setValue(p3.getCookLevel().ordinal());
//        }
//        if (pattyCount >= 4) {
//            Patty p4 = templatePatties.get(3);
//            patty4Type.setValue(p4.getType());
//            patty4Seasoning.setValue(p4.getSeasoning());
//            patty4Cook.setValue(p4.getCookLevel().ordinal());
//        }
        // 4. Set cheese details for each cheese slot (assuming equal number as patties)
        List<Cheese> templateCheese = fromTemplate.getCheeses();
        if (!templateCheese.isEmpty()) {
            // e.g., if pattyCount is 1, we expect one cheese slice in list, etc.

            Cheese c1 = templateCheese.getFirst();
            chzTypeCombo.setValue(c1.getName());
            smokedCheck.setSelected(c1.isSmoked());
            agedCheck.setSelected(c1.isAged());
            chzAmtCombo.setValue("1x");
//            if (templateCheese.size() >= 2) {
//                Cheese c2 = templateCheese.get(1);
//                cheese2Type.setValue(c2.getType());
//                cheese2Smoked.setSelected(c2.isSmoked());
//                cheese2Aged.setSelected(c2.isAged());
//            }
//            if (templateCheese.size() >= 3) {
//                Cheese c3 = templateCheese.get(2);
//                cheese3Type.setValue(c3.getType());
//                cheese3Smoked.setSelected(c3.isSmoked());
//                cheese3Aged.setSelected(c3.isAged());
//            }
//            if (templateCheese.size() >= 4) {
//                Cheese c4 = templateCheese.get(3);
//                cheese4Type.setValue(c4.getType());
//                cheese4Smoked.setSelected(c4.isSmoked());
//                cheese4Aged.setSelected(c4.isAged());
//            }

            // 5. Set garnish checkboxes (check those present in template, uncheck others)
            List<Garnish> garnList = fromTemplate.getGarnishes();
            lettuceChk.setSelected(garnList.contains(Garnish.LETTUCE));
            tomatoChk.setSelected(garnList.contains(Garnish.TOMATO));
            onionChk.setSelected(garnList.contains(Garnish.ONION));
            pickleChk.setSelected(garnList.contains(Garnish.PICKLES));
            avacadoChk.setSelected(garnList.contains(Garnish.AVACADO));
            cookOnionChk.setSelected(garnList.contains(Garnish.COOKED_ONION));
            baconChk.setSelected(garnList.contains(Garnish.BACON));
            mushroomChk.setSelected(garnList.contains(Garnish.MUSHROOMS));
        }
    }

    // Helper to update visibility of patty/cheese input sections
    private void updatePattyAndCheeseSections(int count) {
        // Show/hide patty and cheese rows based on count (implementation shown later)
        // ...
    }

    @FXML
    protected void handleAddToCart() throws IOException {
        Burger newBurg = makeBurger();
        cartManager.addItem(newBurg);
        setRoot("Main.fxml");
    }

    @FXML
    protected void handlePayNow() throws IOException {
        Burger newBurg = makeBurger();
        cartManager.addItem(newBurg);
        setRoot("ShopCart.fxml");
    }

    private Burger makeBurger() {
        Bun uBun = MenuItem.fromItemName(Bun.class, bunCombo.getValue());
        ArrayList<Patty> uPatties = new ArrayList<>();
        ArrayList<Cheese> uCheeses = new ArrayList<>();
        ArrayList<Garnish> uGarnish = new ArrayList<>();

        // Bun Process
        uBun.customize(toastedCheck.isSelected());
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