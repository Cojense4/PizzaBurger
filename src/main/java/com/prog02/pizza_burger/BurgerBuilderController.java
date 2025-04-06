package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.burger.*;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Map;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static com.prog02.pizza_burger.App.*;

public class BurgerBuilderController implements Initializable {
    @FXML
    private VBox shopCartPaneContainer;
    // templates
    @FXML
    JFXComboBox<String> templateCombo;
    // buns
    @FXML
    JFXComboBox<String> bunCombo;
    @FXML
    JFXCheckBox toastedCheck;
    // Patties
    @FXML
    HBox patBox1, patBox2, patBox3, patBox4;
    @FXML
    JFXComboBox<String> pattyCountCombo, patTypeCombo1, patSeasonCombo1, patTypeCombo2, patSeasonCombo2, patTypeCombo3, patSeasonCombo3, patTypeCombo4, patSeasonCombo4;
    @FXML
    JFXSlider patCookSlide1, patCookSlide2, patCookSlide3, patCookSlide4;
    //Cheese
    @FXML
    HBox chzBox1, chzBox2, chzBox3, chzBox4;
    @FXML
    JFXComboBox<String> chzTypeCombo1, chzTypeCombo2, chzTypeCombo3, chzTypeCombo4;
    @FXML
    JFXCheckBox chzSmokeChk1, chzAgeChk1, chzDubChk1, chzSmokeChk2, chzAgeChk2, chzDubChk2, chzSmokeChk3, chzAgeChk3, chzDubChk3, chzSmokeChk4, chzAgeChk4, chzDubChk4;
    // Garnishes
    @FXML
    JFXCheckBox lettuceChk, avacadoChk, onionChk, tomatoChk, pickleChk, mushroomChk, baconChk, cookOnionChk;
    // Non-FXML variables
    Map<Integer, String> seasoningMap;
    CartManager cartManager = CartManager.getInstance();
    Patty exPatty = Patty.BEEF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (BurgerTemplate templates : BurgerTemplate.values()) {
            templateCombo.getItems().add(templates.getName());
        }
        // Buns
        for (Bun bun : Bun.values()) {
            bunCombo.getItems().add(bun.getName());
        }
        // Patties
        pattyCountCombo.setValue("1");
        for (Patty patty : Patty.values()) {
            patTypeCombo1.getItems().add(patty.getName());
            patTypeCombo2.getItems().add(patty.getName());
            patTypeCombo3.getItems().add(patty.getName());
            patTypeCombo4.getItems().add(patty.getName());
        }
        seasoningMap = exPatty.getSeasoningMap();
        for (int x = 0; x < 4; x++) {
            patSeasonCombo1.getItems().add(seasoningMap.get(x));
            patSeasonCombo2.getItems().add(seasoningMap.get(x));
            patSeasonCombo3.getItems().add(seasoningMap.get(x));
            patSeasonCombo4.getItems().add(seasoningMap.get(x));
            pattyCountCombo.getItems().add(String.valueOf(x+1));
        }
        // Cheeses
        for (Cheese cheese : Cheese.values()) {
            chzTypeCombo1.getItems().add(cheese.getName());
            chzTypeCombo2.getItems().add(cheese.getName());
            chzTypeCombo3.getItems().add(cheese.getName());
            chzTypeCombo4.getItems().add(cheese.getName());
        }
    }

    @FXML
    protected void handleUseTemplate() {
        BurgerTemplate fromTemplate = MenuItem.fromItemName(BurgerTemplate.class, templateCombo.getValue());
        if (fromTemplate == null) return;

        // 1. Set bun selections
        Bun tBun = fromTemplate.getBun();
        bunCombo.setValue(tBun.getName());
        toastedCheck.setSelected(tBun.isToasted());

        // 2. Set patty details for each patty slot
        ArrayList<Patty> tPatties = fromTemplate.getPatties();
        pattyCountCombo.setValue(String.valueOf(tPatties.size()));
        if (!tPatties.isEmpty()) {
            Patty p1 = tPatties.getFirst();
            patTypeCombo1.setValue(p1.getName());
            patSeasonCombo1.setValue(p1.getSeasonStr());
            patCookSlide1.setValue(p1.getCookInt());

            if (tPatties.size() >= 2) {
                Patty p2 = tPatties.get(1);
                patTypeCombo2.setValue(p2.getName());
                patSeasonCombo2.setValue(p2.getSeasonStr());
                patCookSlide2.setValue(p2.getCookInt());
            }
            if (tPatties.size() >= 3) {
                Patty p3 = tPatties.get(2);
                patTypeCombo3.setValue(p3.getName());
                patSeasonCombo3.setValue(p3.getSeasonStr());
                patCookSlide3.setValue(p3.getCookInt());
            }
            if (tPatties.size() >= 4) {
                Patty p4 = tPatties.get(3);
                patTypeCombo4.setValue(p4.getName());
                patSeasonCombo4.setValue(p4.getSeasonStr());
                patCookSlide4.setValue(p4.getCookInt());
            }
        }

        // 3. Set cheese details for each cheese slot
        ArrayList<Cheese> tCheeses = fromTemplate.getCheeses();
        if (!tCheeses.isEmpty()) {
            Cheese chz1 = tCheeses.getFirst();
            chzTypeCombo1.setValue(chz1.getName());
            chzSmokeChk1.setSelected(chz1.isSmoked());
            chzAgeChk1.setSelected(chz1.isAged());

            if (tCheeses.size() >= 2) {
                Cheese chz2 = tCheeses.get(1);
                chzTypeCombo2.setValue(chz2.getName());
                chzSmokeChk2.setSelected(chz2.isSmoked());
                chzAgeChk2.setSelected(chz2.isAged());
                chzBox2.setVisible(true);
            }
            if (tCheeses.size() >= 3) {
                Cheese chz3 = tCheeses.get(2);
                chzTypeCombo3.setValue(chz3.getName());
                chzSmokeChk3.setSelected(chz3.isSmoked());
                chzAgeChk3.setSelected(chz3.isAged());
                chzBox3.setVisible(true);
            }
            if (tCheeses.size() >= 4) {
                Cheese chz4 = tCheeses.get(3);
                chzTypeCombo4.setValue(chz4.getName());
                chzSmokeChk4.setSelected(chz4.isSmoked());
                chzAgeChk4.setSelected(chz4.isAged());
                chzBox4.setVisible(true);
            }

            // 4. Set garnish checkboxes
            ArrayList<Garnish> tGarnishes = fromTemplate.getGarnishes();
            lettuceChk.setSelected(tGarnishes.contains(Garnish.LETTUCE));
            tomatoChk.setSelected(tGarnishes.contains(Garnish.TOMATO));
            onionChk.setSelected(tGarnishes.contains(Garnish.ONION));
            pickleChk.setSelected(tGarnishes.contains(Garnish.PICKLES));
            avacadoChk.setSelected(tGarnishes.contains(Garnish.AVACADO));
            cookOnionChk.setSelected(tGarnishes.contains(Garnish.COOKED_ONION));
            baconChk.setSelected(tGarnishes.contains(Garnish.BACON));
            mushroomChk.setSelected(tGarnishes.contains(Garnish.MUSHROOMS));
        }
    }
    @FXML
    protected void handlePatAmtChange(ActionEvent event) {
        int patAmt = (pattyCountCombo.getValue() != null)
                ? Integer.parseInt(pattyCountCombo.getValue().replaceAll("\\D",""))
                : Integer.parseInt(pattyCountCombo.getValue());
        if (patAmt < 1) patAmt = 1;
        if (patAmt > 4) patAmt = 4;

        patBox1.setVisible(true);
        patBox2.setVisible(patAmt >= 2);
        patBox3.setVisible(patAmt >= 3);
        patBox4.setVisible(patAmt == 4);

        chzBox1.setVisible(true);
        chzBox2.setVisible(patAmt >= 2);
        chzBox3.setVisible(patAmt >= 3);
        chzBox4.setVisible(patAmt == 4);
    }
    @FXML
    protected void handleAddToCart() throws IOException {
        Burger newBurg = makeBurger();
        cartManager.addItem(newBurg);
        reloadShopCartPane();
        App.setRoot("BurgerBuilder.fxml");
    }
    @FXML
    protected void handlePayNow() throws IOException {
        Burger newBurg = makeBurger();
        cartManager.addItem(newBurg);
        setRoot("Completed.fxml");
    }
    @FXML
    protected void handleBackToMenu() throws IOException {
        Burger newBurg = makeBurger();
        cartManager.addItem(newBurg);
        setRoot("Main.fxml");
    }

    // Creates a burger from on-screen elements
    private Burger makeBurger() {
        // 1. Get bun and set if toasted
        Bun uBun = MenuItem.fromItemName(Bun.class, bunCombo.getValue());
        uBun.setToasted(toastedCheck.isSelected());

        // 2. Set patty details for each patty slot
        ArrayList<Patty> uPatties = new ArrayList<>();
        if (Integer.parseInt(pattyCountCombo.getValue()) >= 1) {
            Patty pat1 = MenuItem.fromItemName(Patty.class, patTypeCombo1.getValue());
            pat1.setSeasoning(keyFromVal(seasoningMap, patSeasonCombo1.getValue()));
            pat1.setCookLevel((int) patCookSlide1.getValue());
            uPatties.add(pat1);
        }
        if (Integer.parseInt(pattyCountCombo.getValue()) >= 2) {
            Patty pat2 = MenuItem.fromItemName(Patty.class, patTypeCombo2.getValue());
            pat2.setSeasoning(keyFromVal(seasoningMap, patSeasonCombo2.getValue()));
            pat2.setCookLevel((int) patCookSlide2.getValue());
            uPatties.add(pat2);
        }
        if (Integer.parseInt(pattyCountCombo.getValue()) >= 3) {
            Patty pat3 = MenuItem.fromItemName(Patty.class, patTypeCombo3.getValue());
            pat3.setSeasoning(keyFromVal(seasoningMap, patSeasonCombo3.getValue()));
            pat3.setCookLevel((int) patCookSlide3.getValue());
            uPatties.add(pat3);
        }
        if (Integer.parseInt(pattyCountCombo.getValue()) >= 4) {
            Patty pat4 = MenuItem.fromItemName(Patty.class, patTypeCombo4.getValue());
            pat4.setSeasoning(keyFromVal(seasoningMap, patSeasonCombo4.getValue()));
            pat4.setCookLevel((int) patCookSlide4.getValue());
            uPatties.add(pat4);
        }
        
        // 3. Set cheese details for each cheese slot
        ArrayList<Cheese> uCheeses = new ArrayList<>();
        if (Integer.parseInt(pattyCountCombo.getValue()) >= 1) {
            Cheese chz1 = MenuItem.fromItemName(Cheese.class, chzTypeCombo1.getValue());
            chz1.setIsSmoked(chzSmokeChk1.isSelected());
            chz1.setIsAged(chzAgeChk1.isSelected());
            uCheeses.add(chz1);
        }
        if (Integer.parseInt(pattyCountCombo.getValue()) >= 2) {
            Cheese chz2 = MenuItem.fromItemName(Cheese.class, chzTypeCombo2.getValue());
            chz2.setIsSmoked(chzSmokeChk2.isSelected());
            chz2.setIsAged(chzAgeChk2.isSelected());
            uCheeses.add(chz2);
        }
        if (Integer.parseInt(pattyCountCombo.getValue()) >= 3) {
            Cheese chz3 = MenuItem.fromItemName(Cheese.class, chzTypeCombo3.getValue());
            chz3.setIsSmoked(chzSmokeChk3.isSelected());
            chz3.setIsAged(chzAgeChk3.isSelected());
            uCheeses.add(chz3);
        }
        if (Integer.parseInt(pattyCountCombo.getValue()) >= 4) {
            Cheese chz4 = MenuItem.fromItemName(Cheese.class, chzTypeCombo4.getValue());
            chz4.setIsSmoked(chzSmokeChk4.isSelected());
            chz4.setIsAged(chzAgeChk4.isSelected());
            uCheeses.add(chz4);
        }

        // 4. Set garnish checkboxes
        ArrayList<Garnish> uGarnishes = new ArrayList<>();
        if (tomatoChk.isSelected()) {
            uGarnishes.add(Garnish.TOMATO);
        }
        if (lettuceChk.isSelected()) {
            uGarnishes.add(Garnish.LETTUCE);
        }
        if (avacadoChk.isSelected()) {
            uGarnishes.add(Garnish.AVACADO);
        }
        if (pickleChk.isSelected()) {
            uGarnishes.add(Garnish.PICKLES);
        }
        if (onionChk.isSelected()) {
            uGarnishes.add(Garnish.ONION);
        }
        if (cookOnionChk.isSelected()) {
            uGarnishes.add(Garnish.COOKED_ONION);
        }
        if (baconChk.isSelected()) {
            uGarnishes.add(Garnish.BACON);
        }
        if (mushroomChk.isSelected()) {
            uGarnishes.add(Garnish.MUSHROOMS);
        }

        // 5. Return the new burger (if not template, then custom burger
        Burger uBurg = new Burger(uBun, uPatties, uCheeses, uGarnishes);
        if (templateCombo.getValue() == null) {
            uBurg.setItemName("Custom Burger");
        } else {
            uBurg.setItemName(templateCombo.getValue());
        }
        return uBurg;
    }

    private void reloadShopCartPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShopCartPane.fxml"));
            VBox newShopCartPane = loader.load();
            // Get the parent container (e.g., an HBox)
            HBox parent = (HBox) shopCartPaneContainer.getParent();
            // Find the index of the old shop cart pane
            int index = parent.getChildren().indexOf(shopCartPaneContainer);
            // Replace the old node with the new one
            parent.getChildren().set(index, newShopCartPane);
            // Update the reference if needed
            shopCartPaneContainer = newShopCartPane;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Utility method that probably should be replaced as only one thing uses it
    private int keyFromVal(Map < Integer, String > uMap, String sVal){
        for (Map.Entry<Integer, String> entry : uMap.entrySet()) {
            if (entry.getValue().equals(sVal)) {
                return entry.getKey();
            }
        }
        return 2;
    }
}