package com.prog02.pizza_burger;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.pizza.*;
import com.prog02.pizza_burger.model.user.CartManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.prog02.pizza_burger.App.setRoot;

public class PizzaBuilderController implements Initializable {
    @FXML
    private VBox shopCartPaneContainer;
    // Templates
    @FXML
    JFXComboBox<String> templateCombo;
    // Crusts
    @FXML
    JFXComboBox<String> crustCombo, crustSizeCombo;
    // Sauces
    @FXML
    JFXComboBox<String> sauceCombo1, sauceCombo2,
            sauceAmtCombo1, sauceAmtCombo2,
            sauceCountCombo;
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
    @FXML
    VBox sauceBox1, sauceBox2;
    // Non-FXML variables
    Map<Integer, String> sauceAmtMap = Sauce.TRADITIONAL.getSauceMap();
    Map<Integer, String> crustSizeMap = Crust.TRADITIONAL.getSizeMap();
    CartManager cartManager = CartManager.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (PizzaTemplate pizzaTemplate : PizzaTemplate.values()) {
            templateCombo.getItems().add(pizzaTemplate.getName());
        }
        // Crusts
        for (Crust crust : Crust.values()) {
            crustCombo.getItems().add(crust.getName());
        }
        for (String crustSize : crustSizeMap.values() ) {
            crustSizeCombo.getItems().add(crustSize);
        }
        // Sauces
        for (int x = 0; x < 2; x++) {
            sauceCountCombo.getItems().add(String.valueOf(x+1));
        }
        for (Sauce sauce : Sauce.values()) {
            sauceCombo1.getItems().add(sauce.getName());
            sauceCombo2.getItems().add(sauce.getName());
        }
        for (String sauceAmt : sauceAmtMap.values()) {
            sauceAmtCombo1.getItems().add(sauceAmt);
            sauceAmtCombo2.getItems().add(sauceAmt);
        }
        sauceCountCombo.setValue("1");
        // Toppings
        for (int x = 0; x < 3; x++) {
            chzCountCombo.getItems().add(String.valueOf(x));
            meatCountCombo.getItems().add(String.valueOf(x));
            vegCountCombo.getItems().add(String.valueOf(x));
            extraCountCombo.getItems().add(String.valueOf(x));
        }
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
        chzCountCombo.setValue("1");
        meatCountCombo.setValue("0");
        vegCountCombo.setValue("0");
        extraCountCombo.setValue("0");
        handleAmtChg();
    }
    
    @FXML
    protected void handleUseTemplate() {
        PizzaTemplate uTemplate = MenuItem.fromItemName(PizzaTemplate.class, templateCombo.getValue());
        if (uTemplate == null) return;

        // 1. Set crust selections
        Crust tCrust = uTemplate.getCrust();
        crustCombo.setValue(tCrust.getName());
        crustSizeCombo.setValue(tCrust.getSizeStr());

        // 2. Set Sauce details
        ArrayList<Sauce> tSauces = uTemplate.getSauces();
        sauceCountCombo.setValue(String.valueOf(tSauces.size()));
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
        ArrayList<Topping> tExtras = uTemplate.getExtraToppings();
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

    // hopefully there is some way to simplify this code lol
    @FXML
    protected void handleAmtChg() {
        // Sauce Boxes
        int sauceCount = Integer.parseInt(sauceCountCombo.getValue());
        if (sauceCount <= 0) sauceCount = 0;
        if (sauceCount > 2) sauceCount = 2;
        sauceBox1.setVisible(sauceCount > 0);
        sauceBox2.setVisible(sauceCount == 2);
        // Cheese Boxes
        int chzCount = (chzCountCombo.getValue() != null)
                ? Integer.parseInt(chzCountCombo.getValue().replaceAll("\\D",""))
                : Integer.parseInt(chzCountCombo.getValue());
        if (chzCount <= 0) chzCount = 0;
        if (chzCount >= 2) chzCount = 2;
        chzBox1.setVisible(chzCount >= 1);
        chzBox2.setVisible(chzCount == 2);
        // Meat Boxes
        int meatCount = (meatCountCombo.getValue() != null)
                ? Integer.parseInt(meatCountCombo.getValue().replaceAll("\\D",""))
                : Integer.parseInt(meatCountCombo.getValue());
        if (meatCount <= 0) meatCount = 0;
        if (meatCount >= 2) meatCount = 2;
        meatBox1.setVisible(meatCount >= 1);
        meatBox2.setVisible(meatCount == 2);
        // Veggie Boxes
        int vegCount = (vegCountCombo.getValue() != null)
                ? Integer.parseInt(vegCountCombo.getValue().replaceAll("\\D",""))
                : Integer.parseInt(vegCountCombo.getValue());
        if (vegCount <= 0) vegCount = 0;
        if (vegCount >= 2) vegCount = 2;
        vegBox1.setVisible(vegCount >= 1);
        vegBox2.setVisible(vegCount == 2);
        // Extra Boxes
        int extraCount = (extraCountCombo.getValue() != null)
                ? Integer.parseInt(extraCountCombo.getValue().replaceAll("\\D",""))
                : Integer.parseInt(extraCountCombo.getValue());
        if (extraCount <= 0) extraCount = 0;
        if (extraCount >= 2) extraCount = 2;
        extraBox1.setVisible(extraCount >= 1);
        extraBox2.setVisible(extraCount == 2);
    }
    @FXML
    protected void handleBackToMenu() throws IOException {
        setRoot("Main.fxml");
    }

    @FXML
    protected void handleAddToCart() throws IOException {
        if (completeCheck()){
            Pizza newPiz = makePizza();
            cartManager.addItem(newPiz);
            reloadShopCartPane();
        }
    }

    @FXML
    protected void handlePayNow() throws IOException {
        setRoot("ShopCart.fxml");
    }

    private Pizza makePizza() {
        // Crust Process
        Crust uCrust = MenuItem.fromItemName(Crust.class, crustCombo.getValue());
        uCrust.setSize(keyFromVal(crustSizeMap, crustSizeCombo.getValue()));

        // Sauce Process
        ArrayList<Sauce> uSauces = new ArrayList<>();
        if (sauceCombo1.getValue() != null) {
            Sauce s1 = MenuItem.fromItemName(Sauce.class, sauceCombo1.getValue());
            s1.setAmount(keyFromVal(sauceAmtMap, sauceCombo1.getValue()));
            uSauces.add(s1);
        }
        if (sauceCombo2.getValue() != null) {
            Sauce s2 = MenuItem.fromItemName(Sauce.class, sauceCombo2.getValue());
            s2.setAmount(keyFromVal(sauceAmtMap, sauceCombo2.getValue()));
            uSauces.add(s2);
        }

        // Topping Process
        ArrayList<Topping> uToppings = new ArrayList<>();
        if (chzCombo1.getValue() != null) {
            Topping c1 = MenuItem.fromItemName(Topping.class, chzCombo1.getValue());
            c1.setIsDouble(chzDubChk1.isSelected());
            uToppings.add(c1);
        }
        if (chzCombo2.getValue() != null) {
            Topping c2 = MenuItem.fromItemName(Topping.class, chzCombo2.getValue());
            c2.setIsDouble(chzDubChk2.isSelected());
            uToppings.add(c2);
        }
        if (meatCombo1.getValue() != null) {
            Topping m1 = MenuItem.fromItemName(Topping.class, meatCombo1.getValue());
            m1.setIsDouble(meatDubChk1.isSelected());
            uToppings.add(m1);
        }
        if (meatCombo2.getValue() != null) {
            Topping m2 = MenuItem.fromItemName(Topping.class, meatCombo2.getValue());
            m2.setIsDouble(meatDubChk2.isSelected());
            uToppings.add(m2);
        }
        if (vegCombo1.getValue() != null) {
            Topping v1 = MenuItem.fromItemName(Topping.class, vegCombo1.getValue());
            v1.setIsDouble(vegDubChk1.isSelected());
            uToppings.add(v1);
        }
        if (vegCombo2.getValue() != null) {
            Topping v2 = MenuItem.fromItemName(Topping.class, vegCombo2.getValue());
            v2.setIsDouble(vegDubChk2.isSelected());
            uToppings.add(v2);
        }
        if (extraCombo1.getValue() != null) {
            Topping e1 = MenuItem.fromItemName(Topping.class, extraCombo1.getValue());
            e1.setIsDouble(extraDubChk1.isSelected());
            uToppings.add(e1);
        }
        if (extraCombo2.getValue() != null) {
            Topping e2 = MenuItem.fromItemName(Topping.class, extraCombo2.getValue());
            e2.setIsDouble(extraDubChk2.isSelected());
            uToppings.add(e2);
        }
        // 5. Return the new pizza (if not template, then "Custom Pizza")
        Pizza uPizza = new Pizza(uCrust, uSauces, uToppings);
        if (templateCombo.getValue() == null) {
            uPizza.setItemName("Custom Pizza");
        } else {
            uPizza.setItemName(templateCombo.getValue());
        }
        return uPizza;
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

    private int keyFromVal(Map < Integer, String > uMap, String sVal){
        for (Map.Entry<Integer, String> entry : uMap.entrySet()) {
            if (entry.getValue().equals(sVal)) {
                return entry.getKey();
            }
        }
        return 2;
    }
    private boolean completeCheck() {
        // Crust completion
        if (crustCombo.getValue() == null || crustCombo.getValue().isEmpty()) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a crust for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (crustSizeCombo.getValue() == null || crustSizeCombo.getValue().isEmpty()) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select the size of crust you want for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        // Sauce(s) completion
        if (sauceCountCombo.getValue() == null || sauceCountCombo.getValue().isEmpty()) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select how many sauces you want for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (Integer.parseInt(sauceCountCombo.getValue()) == 1 && (sauceCombo1.getValue() == null || sauceAmtCombo1.getValue() == null)) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select your first sauce type and amount!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (Integer.parseInt(sauceCountCombo.getValue()) == 2 && (sauceCombo2.getValue() == null || sauceAmtCombo2.getValue() == null)) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a second sauce for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        // Topping(s) Completion
        if (chzBox1.isVisible() && (chzCombo1.getValue() == null || chzCombo1.getValue().isEmpty())) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a cheese for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (chzBox2.isVisible() && (chzCombo2.getValue() == null || chzCombo2.getValue().isEmpty())) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a second cheese for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (meatBox1.isVisible() && (meatCombo1.getValue() == null || meatCombo1.getValue().isEmpty())) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a meat for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (meatBox2.isVisible() && (meatCombo2.getValue() == null || meatCombo2.getValue().isEmpty())) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a second meat for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (vegBox1.isVisible() && (vegCombo1.getValue() == null || vegCombo1.getValue().isEmpty())) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a veggie for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (vegBox2.isVisible() && (vegCombo2.getValue() == null || vegCombo2.getValue().isEmpty())) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a second veggie for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (extraBox1.isVisible() && (extraCombo1.getValue() == null || extraCombo1.getValue().isEmpty())) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select an extra topping for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        if (extraBox2.isVisible() && (extraCombo2.getValue() == null || extraCombo2.getValue().isEmpty())) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Incomplete Pizza");
            dialog.setContentText("Please select a second extra topping for your pizza!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.showAndWait();
            return false;
        }
        return true;
    }
}