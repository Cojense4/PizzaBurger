package com.prog02.pizza_burger.pizza.toppings;

public abstract class VeggieTopping extends PizzaTopping {
    protected double price;
    protected String itemName;

    public VeggieTopping(double price, String itemName) {
        super(price, itemName);
        this.price = price;
        this.itemName = itemName;
    }

    public VeggieTopping() {
        super(1.50, "Default Veggie");
        this.price = 1.50;
        this.itemName = "Default Veggie";
    }
}
