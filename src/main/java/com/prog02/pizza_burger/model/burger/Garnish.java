package com.prog02.pizza_burger.model.burger;

import com.prog02.pizza_burger.model.common.MenuItem;

public enum Garnish implements MenuItem {
    // Veggies (above other toppings)
    TOMATO("Tomato Slice", 1.25, true),
    LETTUCE("Iceberg Lettuce", 0.00, true),
    AVACADO("Avacado Slices", 2.00, true),
    PICKLES("Pickle Flats", 0.25, true),
    ONION("Onion Flats", 0.25, true),

    // Non-Veggies (Below veggies)
    COOKED_ONION("Caramelized Onions", 0.75, false),
    BACON("Bacon", 2.25, false),
    MUSHROOMS("Grilled Mushrooms", 0.25, false);

    private String itemName;
    private double price;
    private boolean isVeggie;

    Garnish(String itemName, double price, boolean isVeggie) {
        this.itemName = itemName;
        this.price = price;
        this.isVeggie = isVeggie;
    }

    public String display() {
        return (isVeggie ? "(Veggie) " : "") + this.itemName;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String getName() {
        return itemName + (isVeggie ? " (Veggie)" : "");
    }
    public boolean isVeggie() {
        return this.isVeggie;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }
    public void setName(String name) {
        itemName = name;
    }
    public void setVeggie(boolean newIsVeggie) {
       isVeggie = newIsVeggie;
    }
}
