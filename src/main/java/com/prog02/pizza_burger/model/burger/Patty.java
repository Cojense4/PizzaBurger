package com.prog02.pizza_burger.model.burger;
import com.prog02.pizza_burger.model.common.MenuItem;

public enum Patty implements MenuItem {
    // Cheese
    BEEF("Beef Patty", 5.00, 2, 0),
    WAGYU("Wagyu Patty", 10.00, 2, 0),
    CHICKEN("Chicken Patty", 3.50, 2, 0),
    SALMON("Salmon Patty", 7.75, 2, 0);

    private final String itemName;
    private double price;
    private int cookLevel;
    private int seasonLevel;

    // New constructor with four parameters
    Patty(String itemName, double price, int cookLevel, int seasonLevel) {
        this.itemName = itemName;
        this.price = price;
        this.cookLevel = cookLevel;
        this.seasonLevel = seasonLevel;
    }

    public static Patty fromItemName(String itemName) {
        for (Patty patty : Patty.values()) {
            if (patty.itemName.equals(itemName)) {
                return patty;
            }
        }
        return BEEF;
    }

    public void customizePatty(int newCookLevel, int newSeasonLevel) {
        this.cookLevel = newCookLevel;
        this.seasonLevel = newSeasonLevel;
    }

    public String getSeasoningLevel() {
        return switch (this.seasonLevel) {
            case 1: {
                yield "Light seasonings";
            }
            case 2: {
                yield "Normal seasonings";
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
    public String getName() {
        return this.itemName;
    }

    @Override
    public double getPrice() {
        if (this.seasonLevel > 3) {
            this.seasonLevel = 3;
        }
        return this.price + (this.seasonLevel * 0.25);
    }
}
