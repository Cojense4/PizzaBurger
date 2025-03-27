package com.prog02.pizza_burger.model.burger;

import java.util.ArrayList;

public class Burger {
    private Buns bun;
    private ArrayList<Patties> patties;
    private ArrayList<Cheeses> cheeses;
    private ArrayList<Garnishes> garnishes;

    // Constructor taking the enums.
    public Burger(Buns bun, ArrayList<Patties> patties, ArrayList<Cheeses> cheeses, ArrayList<Garnishes> garnishes) {
        this.bun = bun;
        this.patties = patties;
        this.cheeses = cheeses;
        this.garnishes = garnishes;
    }

    /**
     * Displays the Burger build as a printed receipt.
     */
    public void display() {
        double totalPrice = 0.0;
        System.out.println("----- Burger Receipt -----");

        // Display Crust
        System.out.println("Bun:");
        System.out.println(bun.toNiceString());
        totalPrice += bun.getPrice();

        // Display Patties
        if (patties != null && !patties.isEmpty()) {
            System.out.println("Patties:");
            for (Patties patty : patties) {
                System.out.println(patty.toNiceString());
                totalPrice += patty.getPrice();
            }
        }

        // Display Cheeses, if any
        if (cheeses != null && !cheeses.isEmpty()) {
            System.out.println("Cheeses:");
            for (Cheeses cheese : cheeses) {
                System.out.println(cheese.toNiceString());
                totalPrice += cheese.getPrice();
            }
        }

        // Display Garnishes, if any
        if (garnishes != null && !garnishes.isEmpty()) {
            System.out.println("Garnishes:");
            for (Garnishes topping : garnishes) {
                System.out.println(topping.toNiceString());
                totalPrice += topping.getPrice();
            }
        }

        System.out.println("-------------------------");
        System.out.printf("Total Price: $%.2f\n", totalPrice);
    }

    // Getters and setters if needed
    public Buns getBun() {
        return bun;
    }
    public void setBun(Buns bun) {
        this.bun = bun;
    }

    public ArrayList<Patties> getPatties() {
        return patties;
    }
    public void setPatties(ArrayList<Patties> patties) {
        this.patties = patties;
    }

    public ArrayList<Cheeses> getCheeses() {
        return cheeses;
    }
    public void setCheeses(ArrayList<Cheeses> newCheese) {
        this.cheeses = newCheese;
    }

    public ArrayList<Garnishes> getGarnishes() {
        return garnishes;
    }
    public void setGarnishes(ArrayList<Garnishes> garnishes) {
        this.garnishes = garnishes;
    }
}
