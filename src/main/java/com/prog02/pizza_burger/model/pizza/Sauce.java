package com.prog02.pizza_burger.model.pizza;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Sauce implements MenuItem {
    // Sauce
    ALFREDO("Alfredo Sauce", 3.75, 2),
    TRADITIONAL("Traditional Sauce", 4.50, 2),
    MEAT("Meat Sauce", 5.00, 2),
    SAUCELESS("Sauceless Sauce", 1.00, 2),
    GARLIC("Garlic Butter Sauce", 2.00, 2);

    private final String itemName;
    private double price;
    private int quantity;

    // Enum constructor is private by default.
    Sauce(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
    }

    public void customizeSauce(double newPrice, int newQuantity) {
        this.price = newPrice;
        this.quantity = newQuantity;
    }

    @Override
    public String getName() {
        return this.itemName;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
