package com.prog02.pizza_burger.model.burger;

import com.prog02.pizza_burger.model.common.AbstractMenuItem;
import com.prog02.pizza_burger.model.common.Priceable;
import com.prog02.pizza_burger.model.common.PriceableWrapper;

import java.util.ArrayList;

public class Burger extends AbstractMenuItem {
    private String itemName;
    private Bun bun;
    private ArrayList<Patty> patties;
    private ArrayList<Cheese> cheeses;
    private ArrayList<Garnish> garnishes;

    // Constructor taking the enums.
    public Burger(Bun bun, ArrayList<Patty> patties, ArrayList<Cheese> cheeses, ArrayList<Garnish> garnish) {
        this.bun = bun;
        this.patties = patties;
        this.cheeses = cheeses;
        this.garnishes = garnish;
        this.price = getPrice();
    }

    /**
     * Displays the Burger build as a printed receipt.
     */
    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("---------- %s ----------\n", itemName));
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
        if (garnishes != null && !garnishes.isEmpty()) {
            sb.append("Garnishes:");
            for (Garnish topping : garnishes) {
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
        for (Garnish garnish : garnishes) {
            totalPrice += garnish.getPrice();
        }
        return totalPrice;
    }

    public void setItemName(String newItemName) {
        this.itemName = newItemName;
    }

    /**
     * Returns a sorted ArrayList of all Burger components (crust, sauce, and toppings) based on their price.
     * Components are sorted in ascending order (lowest price first).
     */
    public ArrayList<Priceable> getSortedComponents() {
        ArrayList<Priceable> components = new ArrayList<>();
        if (bun != null) {
            components.add(new PriceableWrapper(bun));
        }
        if (patties != null) {
            for (Patty patty : patties) {
                components.add(new PriceableWrapper(patty));
            }
        }
        if (cheeses != null) {
            for (Cheese cheese : cheeses) {
                components.add(new PriceableWrapper(cheese));
            }
        }
        if (garnishes != null) {
            for (Garnish garnish : garnishes) {
                components.add(new PriceableWrapper(garnish));
            }
        }
        components.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        return components;
    }

//    /* Getters and Setters
//    For use to modify the burger (through BurgerTemplate)
//     */
//    public Bun getBun() { return bun; }
//    public void setBun(Bun bun) { this.bun = bun; }
//
//    public ArrayList<Patty> getPatties() { return patties; }
//    public ArrayList<Cheese> getCheeses() { return cheeses; }
//    public ArrayList<Garnish> getGarnishes() { return garnishes; }
//
//    // Utility to add a patty (for customization)
//    public void addPatty(Patty patty) {
//        if (patties.size() < 4) patties.add(patty); // limit to 4 patties
//    }
//    public void removePatty(int index) {
//        if (index >= 0 && index < patties.size()) patties.remove(index);
//    }
//    // Similar methods for cheese slices if needed
//    public void addCheese(Cheese cheese) {
//        if (cheeses.size() < 4) cheeses.add(cheese);
//    }
//    public void removeCheese(int index) {
//        if (index >= 0 && index < cheeses.size()) cheeses.remove(index);
//    }
}
