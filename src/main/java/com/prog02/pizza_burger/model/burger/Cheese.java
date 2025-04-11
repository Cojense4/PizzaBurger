package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Cheese implements MenuItem {
    // Cheese
    AMERICAN("American Cheese",  1.00, false, false),
    CHEDDAR("Cheddar Cheese", 1.75, false, false),
    GOUDA("Gouda Cheese", 1.50, false, false),
    PEPPER_JACK("Pepper-jack Cheese",  2.00, false, false),
    SWISS("Swiss Cheese", 1.50, false, false);

    private String itemName;
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

    public String display() {
        return (isSmoked ? "Smoked " : "") + (isAged ? "Aged " : "") + this.itemName;
    }

    @Override
    public Long getId() {
        return 0L;
    }

    // Getters and Setters
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
    public String getName() {
        return itemName;
    }
    public Boolean isSmoked() {
        return this.isSmoked;
    }
    public Boolean isAged() {
        return this.isAged;
    }

    public void setName(String newItemName) {
        this.itemName = newItemName;
    }
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    public void setIsSmoked(boolean newIsSmoked) {
        this.isSmoked = newIsSmoked;
    }
    public void setIsAged(boolean newIsAged) {
        this.isAged = newIsAged;
    }
}