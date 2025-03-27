package com.prog02.pizza_burger.model.pizza;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Crusts implements MenuItem {
    // Normal Crusts
    TRADITIONAL("Traditional Crust", 5.00, false),
    THIN("Thin Crust", 4.50, false),
    CAULIFLOWER("Cauliflower Crust", 3.50, false),
    // Deep Dish Crusts
    THICK("Thick Crust", 6.00, true),
    DEEP_DISH("Deep Dish Crust", 7.00, false);

    private final String itemName;
    private final double price;
    private final boolean promptForDeepDish;

    Crusts(String itemName, double price, boolean promptForDeepDish) {
        this.itemName = itemName;
        this.price = price;
        this.promptForDeepDish = promptForDeepDish;
    }

    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public String toNiceString() {
        return getName() + " -- $ " + String.format("%.2f", price);
    }

    public boolean requiresDeepDishPrompt() {
        return promptForDeepDish;
    }
}
