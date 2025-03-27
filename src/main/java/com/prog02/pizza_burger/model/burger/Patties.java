package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Patties implements MenuItem {
    // Cheeses
    BEEF("Beef Patty", 5.00, 2, 0),
    WAGYU("Wagyu Patty", 10.00, 2, 0),
    CHICKEN("Chicken Patty", 3.50, 2, 0),
    SALMON("Salmon Patty", 7.75, 2, 0);

    private final String itemName;
    private final double price;
    private final int cookLevel;
    private int seasonLevel;

    // New constructor with five parameters
    Patties(String itemName, double price, int cookLevel, int seasonLevel) {
        this.itemName = itemName;
        this.price = price;
        this.cookLevel = cookLevel;
        this.seasonLevel = seasonLevel;
    }

    public String getSeasoningLevel() {
        return switch (this.seasonLevel) {
            case 1: {
                yield "Light seasonings";
            }
            case 2: {
                yield "Well seasoned";
            }
            case 3: {
                yield "Extra seasoning";
            }
            default: {
                yield "No seasonings";
            }
        };
    }

    public String getCookLevel() {
        return switch (this.cookLevel) {
            case 1 -> "Rare";
            case 2 -> "Medium Rare";
            case 4 -> "Medium-Well";
            case 5 -> "Well Done";
            default -> "Medium";
        };
    }

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

    @Override
    public String toNiceString() {
        return getSeasoningLevel() + " " + getName() + " -- $" + String.format("%.2f", price);
    }
}
