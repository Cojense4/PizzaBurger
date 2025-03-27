package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Buns implements MenuItem {
    // Cheeses
    BRIOCHE("Brioche Bun", 4.00, true),
    POTATO("Potato Bun", 3.75, true),
    SESAME("Sesame Bun", 3, true),
    SOURDOUGH("Sourdough Bun", 4.25, true);


    private final String itemName;
    private final double price;
    private final boolean isToasted;

    // New constructor with five parameters
    Buns(String itemName, double price, boolean isToasted) {
        this.itemName = itemName;
        this.price = price;
        this.isToasted = isToasted;
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
        return (isToasted ? "Toasted ": "") + getName() + " -- $" + String.format("%.2f", price);
    }
}