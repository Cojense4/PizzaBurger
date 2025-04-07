package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

import java.util.Map;

public enum Patty implements MenuItem {
    // Cheese
    BEEF("Beef Patty", 5.00, 2, 0),
    WAGYU("Wagyu Patty", 10.00, 2, 0),
    CHICKEN("Chicken Patty", 3.50, 2, 0),
    SALMON("Salmon Patty", 7.75, 2, 0);

    private String itemName;
    private double price;
    private int cookLevel;
    private int seasonLevel;
    private final Map<Integer, String> SeasoningsMap = Map.of(
            0, "No seasonings",
            1, "Light seasonings",
            2, "Normal seasonings",
            3, "Extra seasonings"
    );
    private final Map<Integer, String> CookMap = Map.of(
            1, "Rare",
            2, "Medium Rare",
            3, "Medium",
            4, "Medium-Well",
            5, "Well Done"
    );

    // New constructor with four parameters
    Patty(String itemName, double price, int cookLevel, int seasonLevel) {
        this.itemName = itemName;
        this.price = price;
        this.cookLevel = cookLevel;
        this.seasonLevel = seasonLevel;
    }

    @Override
    public String display() {
        return itemName +
                " (" + getSeasonStr() + ")" +
                " (" + getCookStr() + ")";
    }

    // Getters & Setters
    @Override
    public double getPrice() {
        if (this.seasonLevel > 3) {
            this.seasonLevel = 3;
        }
        return this.price + (this.seasonLevel * 0.25);
    }
    @Override
    public String getName() {
        return this.itemName;
    }
    public String getSeasonStr() {
        return SeasoningsMap.get(seasonLevel);
    }
    public int getCookInt() {
        return this.cookLevel;
    }
    public String getCookStr() {
        return CookMap.get(cookLevel);
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    public void setName(String newName) {
        this.itemName = newName;
    }
    public void setSeasoning(int newSeasoning) {
        this.seasonLevel = newSeasoning;
    }
    public void setCookLevel(int newCookLevel) {
        this.cookLevel = newCookLevel;
    }

    // External class Utils
    public Map<Integer, String> getCookMap() {
        return CookMap;
    }
    public Map<Integer, String> getSeasoningMap() {
        return SeasoningsMap;
    };

}
