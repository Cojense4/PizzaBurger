package com.prog02.pizza_burger.model.pizza;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Topping implements MenuItem {
    // Cheese
    ASIAGO("Asiago", "Cheese", 3.75),
    GOUDA("Gouda", "Cheese", 4.50),
    GRUYERE("Gruyere", "Cheese", 3.50),
    MOZZERELLA("Mozzerella", "Cheese", 3.00),
    // Meats
    PEPPERONI("Pepperoni", "Meat", 1.50),
    BACON("Bacon", "Meat", 3.50),
    BEEF("Beef", "Meat", 2.50),
    SAUSAGE("Sausage", "Meat", 2.25),
    // Veggies
    MUSHROOM("Mushroom", "Veggie", 1.75),
    OLIVES("Olives", "Veggie", 1.00),
    PEPPER("Pepper", "Veggie", 1.25),
    TOMATO("Tomato", "Veggie", 1.50);

    private final String itemName;
    private final double price;
    private final String toppingType;

    // Enum constructor is private by default.
    Topping(String itemName, String toppingType, double price) {
        this.itemName = itemName;
        this.price = price;
        this.toppingType = toppingType;
    }

    public String getType() {return this.toppingType;}
    @Override
    public String getName() {
        return this.itemName + " " + this.toppingType;
    }

    @Override
    public double getPrice() {
        return this.price;
    }


}