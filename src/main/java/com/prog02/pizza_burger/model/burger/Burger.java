package com.prog02.pizza_burger.model.burger;

import com.prog02.pizza_burger.model.common.AbstractMenuItem;

import java.util.ArrayList;

public class Burger extends AbstractMenuItem {
    private final double price;
    private final String description;
    private Bun bun;
    private ArrayList<Patty> patties;
    private ArrayList<Cheese> cheeses;
    private ArrayList<Garnish> garnish;

    // Constructor taking the enums.
    public Burger(Bun bun, ArrayList<Patty> patties, ArrayList<Cheese> cheeses, ArrayList<Garnish> garnish) {
        this.bun = bun;
        this.patties = patties;
        this.cheeses = cheeses;
        this.garnish = garnish;
        this.price = getPrice();
        this.description = "";
    }

    /**
     * Displays the Burger build as a printed receipt.
     */
    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------- Burger ----------\n");
        // bun
        sb.append(bun.display()).append("\n");
        // Patties
        if (patties != null && !patties.isEmpty()) {
            for (Patty patty : patties) {
                sb.append(patty.display()).append("\n");
            }
        }
        // Cheeses
        if (cheeses != null && !cheeses.isEmpty()) {
            for (Cheese cheese : cheeses) {
                sb.append(cheese.display()).append("\n");
            }
        }
        // Garnishes
        if (garnish != null && !garnish.isEmpty()) {
            sb.append("Garnishes:");
            for (Garnish topping : garnish) {
                sb.append(topping.display()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        totalPrice += bun.getPrice();
        for (Patty patty : patties) {
            totalPrice += patty.getPrice();
        }
        for (Cheese cheese : cheeses) {
            totalPrice += cheese.getPrice();
        }
        for (Garnish garnish : garnish) {
            totalPrice += garnish.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getName() {
        return "";
    }

}
