package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Bun implements MenuItem {
    // Buns
    BRIOCHE("Brioche Bun", 4.00, true),
    POTATO("Potato Bun", 3.75, true),
    SESAME("Sesame Bun", 3, true),
    SOURDOUGH("Sourdough Bun", 4.25, true);

    private final String itemName;
    private double price;
    private boolean isToasted;

    // New constructor with three parameters
    Bun(String itemName, double price, boolean isToasted) {
        this.itemName = itemName;
        this.price = price;
        this.isToasted = isToasted;
    }

    public void setIsToasted(boolean isToasted) {
        this.isToasted = isToasted;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() { return this.itemName; }

}