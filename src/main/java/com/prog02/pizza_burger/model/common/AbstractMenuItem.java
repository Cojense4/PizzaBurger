package com.prog02.pizza_burger.model.common;

public abstract class AbstractMenuItem implements MenuItem, Comparable<MenuItem> {
    protected String itemName = "";
    protected double price = 0.0;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return itemName;
    }

    // Optionally, add setters if you need to modify these fields
    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int compareTo(MenuItem otherItem) {
        return Double.compare(this.getPrice(), otherItem.getPrice());
    }

}