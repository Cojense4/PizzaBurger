package com.prog02.pizza_burger.pizza.toppings;

public abstract class CheeseTopping extends PizzaTopping {
    protected double price;
    protected String itemName;

    public CheeseTopping(double price, String itemName) {
        super(price, itemName);
        this.price = price;
        this.itemName = itemName;
    }

    public CheeseTopping() {
        super(3.00, "Default Cheese");
        this.price = 3.00;
        this.itemName = "Default Cheese";
    }
}