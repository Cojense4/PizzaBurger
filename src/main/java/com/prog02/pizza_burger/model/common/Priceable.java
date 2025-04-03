package com.prog02.pizza_burger.model.common;

public abstract class Priceable implements MenuItem, Comparable<MenuItem> {
    private final double price;
    private final String itemName;

    public Priceable(double price, String itemName) {
        this.price = price;
        this.itemName = itemName;
    }
    @Override
    public double getPrice() { return this.price; }

    @Override
    public String getName() { return this.itemName; }

    @Override
    public int compareTo(MenuItem otherItem) {
        return Double.compare(this.getPrice(), otherItem.getPrice());    
    }
}
