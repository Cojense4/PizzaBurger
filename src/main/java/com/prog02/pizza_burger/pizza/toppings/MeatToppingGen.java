package com.prog02.pizza_burger.pizza.toppings;

public abstract class MeatTopping extends PizzaTopping {
    protected double price;
    protected String itemName;

    public MeatTopping(double price, String itemName) {
        super(price, itemName);
        this.price = price;
        this.itemName = itemName;
    }

    public MeatTopping() {
        super(3.50, "Default Meat");
        this.price = 3.50;
        this.itemName = "Default Meat";
    }
}