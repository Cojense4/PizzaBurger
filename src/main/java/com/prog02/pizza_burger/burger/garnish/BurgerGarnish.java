package com.prog02.pizza_burger.burger.garnish;
import com.prog02.pizza_burger.common.Priceable;

public abstract class BurgerGarnish extends Priceable {
    protected double price;
    protected boolean isVeggie;
    protected String itemName ;

    @Override
    public abstract String toString();

    public BurgerGarnish(double price, String itemName, boolean isVeggie) {
        super(price, itemName);
        this.price = price;
        this.itemName = itemName;
        this.isVeggie = isVeggie;
    }

    public BurgerGarnish(double price, String itemName) {
        super(price, itemName);
        this.price = price;
        this.itemName = itemName;
        this.isVeggie = false;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public String toNiceString() {
        return "Topping is: " + toString();
    }
}

