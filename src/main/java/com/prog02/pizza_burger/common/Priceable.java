package com.prog02.pizza_burger.common;

public class Priceable implements MenuItem, Comparable<MenuItem> {
    private final double price;

    public Priceable(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(MenuItem otherItem) {
        return Double.compare(this.getPrice(), otherItem.getPrice());    
    }
}
