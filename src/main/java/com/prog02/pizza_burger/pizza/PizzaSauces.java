package com.prog02.pizza_burger.pizza;
import com.prog02.pizza_burger.common.MenuItem;

public enum PizzaSauces implements MenuItem {
    // Sauces
    ALFREDO("Alfredo Sauce", 3.75),
    TRADITIONAL("Traditional Sauce", 4.50),
    MEAT("Meat Sauce", 5.00),
    SAUCELESS("Sauceless Sauce", 1.00),
    GARLIC("Garlic Butter Sauce", 2.00);

    private final String itemName;
    private final double price;

    // Enum constructor is private by default.
    PizzaSauces(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.itemName;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toNiceString() {
        return getName() + " -- $ " + String.format("%.2f", price);
    }
}
