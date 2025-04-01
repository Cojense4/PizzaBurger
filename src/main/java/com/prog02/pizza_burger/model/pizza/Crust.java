package com.prog02.pizza_burger.model.pizza;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Crust implements MenuItem {
    // Normal Crust
    TRADITIONAL("Traditional Crust", 5.00),
    THIN("Thin Crust", 4.50),
    CAULIFLOWER("Cauliflower Crust", 3.50),
    // Deep Dish Crust
    THICK("Thick Crust", 6.00),
    DEEP_DISH("Deep Dish Crust", 7.00);

    private final String itemName;
    private final double price;

    Crust(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}
