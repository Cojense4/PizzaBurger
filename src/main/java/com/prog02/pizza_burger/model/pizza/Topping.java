package com.prog02.pizza_burger.model.pizza;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Topping implements MenuItem {
    // Cheese
    ASIAGO("Asiago", "Cheese", 3.75, false),
    GOUDA("Gouda", "Cheese", 4.50, false),
    GRUYERE("Gruyere", "Cheese", 3.50, false),
    MOZZERELLA("Mozzerella", "Cheese", 3.00, false),
    PROVALONE("Provalone", "Cheese", 3.00, false),
    VEGAN_MOZZ("Vegan Mozzerella", "Cheese", 4.75, false),
    // Meats
    PEPPERONI("Pepperoni", "Meat", 1.50, false),
    BACON("Bacon", "Meat", 3.50, false),
    BEEF("Beef", "Meat", 2.50, false),
    SAUSAGE("Sausage", "Meat", 2.25, false),
    // Veggies
    MUSHROOM("Mushroom", "Veggie", 1.75, false),
    OLIVES("Olives", "Veggie", 1.00, false),
    PEPPER("Pepper", "Veggie", 1.25, false),
    TOMATO("Tomato", "Veggie", 1.50, false);

    private String itemName;
    private double price;
    private String toppingType;
    private boolean isDouble;

    // Enum constructor is private by default.
    Topping(String itemName, String toppingType, double price, boolean isDouble) {
        this.itemName = itemName;
        this.price = price;
        this.toppingType = toppingType;
        this.isDouble = false;
    }

    @Override
    public String display() {
        return (isDouble? "2x - " : "1x - ") + this.itemName + " (" + this.toppingType + ")";
    }

    @Override
    public String getName() {
        return itemName;
    }
    public String getType() {return toppingType;}
    @Override
    public double getPrice() {
        if (isDouble) {
            return this.price * 2;
        }
        return this.price;
    }
    public boolean isDouble() {return isDouble;}

    // Likely not to be used as GUI doesn't allow changes in item components
    public void setPrice(double newPrice) {this.price = newPrice;}
    public void setName(String newName) {this.itemName = newName;}
    public void setType(String newType) {this.toppingType = newType;}
    public void setIsDouble(boolean newIsDouble) {this.isDouble = newIsDouble;}
}
