package com.prog02.pizza_burger.burger.cheese;

import com.prog02.pizza_burger.common.Priceable;

abstract public class BurgerCheese extends Priceable {
    protected String itemName;
    protected double price;
    protected boolean isSmoked;
    protected boolean isAged;


    @Override
    abstract public String toString();

    public BurgerCheese(String itemName, double price, boolean isSmoked, boolean isAged) {
        super(price, itemName);
        this.price = calcPrice(price, isSmoked, isAged);
        this.itemName = itemName;
        this.isSmoked = isSmoked;
        this.isAged = isAged;
    }
    public BurgerCheese(String itemName) { this(itemName, 0.50, false, false); }

    public double calcPrice(double price, boolean isSmoked, boolean isAged) {
        return price + (isSmoked ? 0.25 : 0) + (isAged ? 0.25 : 0);
    };

    protected String getStrPrice() {
        return String.format("%.2f", this.price);
    }

    public String toNiceString() {
        return toString() + "\n" + "Price -- $" + getStrPrice();
    }

}
