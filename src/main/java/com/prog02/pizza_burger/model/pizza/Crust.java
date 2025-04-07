package com.prog02.pizza_burger.model.pizza;
import com.prog02.pizza_burger.model.common.MenuItem;

import java.util.Map;

public enum Crust implements MenuItem {
    // Normal Crust
    TRADITIONAL("Traditional Crust", 5.00, 2),
    THIN("Thin Crust", 4.50, 2),
    CAULIFLOWER("Cauliflower Crust", 3.50, 2),
    // Deep Dish Crust
    THICK("Thick Crust", 6.00, 2),
    DEEP_DISH("Deep Dish Crust", 8.00, 2);

    private String itemName;
    private double price;
    private int size;
    private final Map<Integer, String> sizeMap = Map.of(
            0, "Personal",
            1, "Small",
            2, "Medium",
            3, "Large",
            4, "x-Large",
            5, "Kingly"
    );

    // New constructor with three parameters
    Crust(String itemName, double price, int size) {
        this.itemName = itemName;
        this.price = price;
        this.size = size;
    }

    @Override
    public String display() { return itemName + " (" + getSizeStr() + ")"; }

    @Override
    public String getName() { return itemName; }
    @Override
    public double getPrice() {
        return price;
    }
    public int getSizeInt() {
        return size;
    }
    public String getSizeStr() {return sizeMap.get(size);}

    public void setPrice(double newPrice) {
        price = newPrice;
    }
    public void setName(String newName) {
        itemName = newName;
    }
    public void setSize(int newSize) {
        this.size = newSize;
    }

    public Map<Integer, String> getSizeMap() {return sizeMap;}
}
