package com.prog02.pizza_burger.model.common;

public abstract class AbstractMenuItem implements MenuItem, Comparable<MenuItem> {
    protected double price;
    protected String itemName;

    // Adds ability to set and get price of an item if needed
    public double getPrice() {
        return price;
    }
    public String getName() {
        return itemName;
    }

    protected void setPrice(double price) {
        this.price = price;
    }
    protected void setName(String itemName) {
        this.itemName = itemName;
    }

    public int compareTo(MenuItem otherItem) { return Double.compare(this.getPrice(), otherItem.getPrice()); }
}