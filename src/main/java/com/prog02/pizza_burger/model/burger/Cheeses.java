package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Cheeses implements MenuItem {
    // Cheeses
    AMERICAN("American", "Cheese Slice", 1.00, false, false),
    WHITE_AMERICAN("Gouda", "Cheese", 1.75, false, false),
    GOUDA("Gouda", "Cheese", 1.50, false, false),
    PEPPERJACK("PepperJack", "Cheese", 2.00, false, false),
    SWISS("Swiss", "Cheese", 1.50, false, false);

    private final String itemName;
    private final String toppingType;
    private final double price;
    private final boolean isSmoked;
    private final boolean isAged;

    // New constructor with five parameters
    Cheeses(String itemName, String toppingType, double price, boolean isSmoked, boolean isAged) {
        this.itemName = itemName;
        this.toppingType = toppingType;
        this.price = price;
        this.isSmoked = isSmoked;
        this.isAged = isAged;
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

    @Override
    public String toNiceString() {
        return getName() + " -- $" + String.format("%.2f", price);
    }
}