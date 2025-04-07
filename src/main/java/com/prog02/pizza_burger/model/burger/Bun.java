package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Bun implements MenuItem {
    // Buns
    BRIOCHE("Brioche Bun", 4.00, true),
    POTATO("Potato Bun", 3.75, false),
    SESAME("Sesame Bun", 3, false),
    SOURDOUGH("Sourdough Bun", 4.25, false);

    private String itemName;
    private double price;
    private boolean isToasted;

    // New constructor with three parameters
    Bun(String itemName, double price, boolean isToasted) {
        this.itemName = itemName;
        this.price = price;
        this.isToasted = isToasted;
    }

    @Override
    public String display() {
        return (isToasted) ? "Toasted " + itemName : itemName;
    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String getName() { return itemName; }
    public boolean isToasted() {
        return isToasted;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }
    public void setName(String newName) {
        itemName = newName;
    }
    public void setToasted(boolean newIsToasted) {
        this.isToasted = newIsToasted;
    }
}