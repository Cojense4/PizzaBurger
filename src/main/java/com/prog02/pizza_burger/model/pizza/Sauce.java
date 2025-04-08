package com.prog02.pizza_burger.model.pizza;
import com.prog02.pizza_burger.model.common.MenuItem;

import java.util.Map;

public enum Sauce implements MenuItem {
    // Sauce
    ALFREDO("Alfredo Sauce", 3.75, 2),
    TRADITIONAL("Traditional Sauce", 4.50, 2),
    MEAT("Meat Sauce", 5.00, 2),
    SAUCELESS("Sauceless Sauce", 1.00, 2),
    GARLIC("Garlic Butter Sauce", 2.00, 2);

    private String itemName;
    private double price;
    private int amount;
    private final Map<Integer, String> SauceMap = Map.of(
            0, "No",
            1, "Light",
            2, "Regular",
            3, "Extra",
            4, "Kingly"
    );

    // Enum constructor is private by default.
    Sauce(String itemName, double price, int amount) {
        this.itemName = itemName;
        this.price = price;
        this.amount = amount;
    }
    @Override
    public String display() {
        return String.format("(%s) %s", getSauceStr(), this.itemName);
    }

    @Override
    public double getPrice() {
        return price * ((double) amount / 2);
    }
    @Override
    public String getName() {
        return this.itemName;
    }
    public String getSauceStr() {return SauceMap.get(amount);}
    public int getSauceInt() {return amount;}

    public void setPrice(double newPrice) {this.price = newPrice;}
    public void setName(String newName) {this.itemName = newName;}
    public void setAmount(int newQuantity) {this.amount = newQuantity;}

    // External class Utils
    public Map<Integer, String> getSauceMap() {return SauceMap;}
}
