package com.prog02.pizza_burger.model.burger;

import com.prog02.pizza_burger.model.common.MenuItem;

import java.util.ArrayList;

public class Burger implements MenuItem {
    private final double price;
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
    }

    /**
     * Displays the Burger build as a printed receipt.
     */
    public void display() {
        double totalPrice = 0.0;
        System.out.println("----- Burger Receipt -----");

        // Display Crust
        bun.display();
        totalPrice += bun.getPrice();

        // Display Patty
        if (patties != null && !patties.isEmpty()) {
            for (Patty patty : patties) {
                patty.display();
                totalPrice += patty.getPrice();
            }
        }

        // Display Cheese, if any
        if (cheeses != null && !cheeses.isEmpty()) {
            for (Cheese cheese : cheeses) {
                cheese.display();
                totalPrice += cheese.getPrice();
            }
        }

        // Display Garnish, if any
        if (garnish != null && !garnish.isEmpty()) {
            System.out.println("Garnishes:");
            for (Garnish topping : garnish) {
                topping.display();
                totalPrice += topping.getPrice();
            }
        }

        System.out.println("-------------------------");
        System.out.printf("Total Price: $%.2f\n", totalPrice);
    }

    // Getters and setters if needed
    public Bun getBun() {
        return bun;
    }
    public void setBun(Bun bun) {
        this.bun = bun;
    }

    public ArrayList<Patty> getPatties() {
        return patties;
    }
    public void setPatties(ArrayList<Patty> patties) {
        this.patties = patties;
    }

    public ArrayList<Cheese> getCheeses() {
        return cheeses;
    }
    public void setCheeses(ArrayList<Cheese> newCheese) {
        this.cheeses = newCheese;
    }

    public ArrayList<Garnish> getGarnishes() {
        return garnish;
    }
    public void setGarnishes(ArrayList<Garnish> garnish) {
        this.garnish = garnish;
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
