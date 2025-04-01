package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Cheese implements MenuItem {
    // Cheese
    AMERICAN("American",  1.00, false, false),
    WHITE_AMERICAN("Gouda", 1.75, false, false),
    GOUDA("Gouda", 1.50, false, false),
    PEPPERJACK("PepperJack",  2.00, false, false),
    SWISS("Swiss", 1.50, false, false);

    private final String itemName;
    private double price;
    private boolean isSmoked;
    private boolean isAged;

    // New constructor with four parameters
    Cheese(String itemName, double price, boolean isSmoked, boolean isAged) {
        this.itemName = itemName;
        this.price = price;
        this.isSmoked = isSmoked;
        this.isAged = isAged;
    }

    public void customizeCheese(boolean newIsSmoked, boolean newIsAged) {
        this.isSmoked = newIsSmoked;
        this.isAged = newIsAged;
    }

    @Override
    public String getName() {
        return (isSmoked ? "Smoked " : "") + (isAged ? "Aged " : "") + this.itemName + " Cheese";
    }

    @Override
    public double getPrice() {
        double extra = 0.0;
        if (isSmoked) {
            extra += 0.25;
        }
        if (isAged) {
            extra += 0.25;
        }
        return this.price + extra;
    }

}