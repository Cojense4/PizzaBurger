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

    private final String itemName;
    private final double price;
    private final boolean isVeggie;

    Garnish(String itemName, double price, boolean isVeggie) {
        this.itemName = itemName;
        this.price = price;
        this.isVeggie = isVeggie;
    }

    public static Garnish fromItemName(String itemName) {
        for (Garnish garnish : values()) {
            if (garnish.itemName.equals(itemName)) {
                return garnish;
            }
        }
        return TOMATO;
    }


    @Override
    public String getName() {
        return this.itemName + (isVeggie ? " (Veggie)" : "");
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
