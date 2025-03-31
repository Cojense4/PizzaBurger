package com.prog02.pizza_burger.model.pizza;

import java.util.ArrayList;

public class Pizza {
    private Crusts crust;
    private Sauces sauce;
    private ArrayList<Toppings> toppings;

    // Constructor taking the enums.
    public Pizza(Crusts crust, Sauces sauce, ArrayList<Toppings> toppings) {
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    /**
     * Displays the pizza build as a printed receipt.
     */
    public void display() {
        double totalPrice = 0.0;
        System.out.println("----- Pizza Receipt -----");

        // Display Crust
        System.out.println("Crust:");
        crust.display();
        totalPrice += crust.getPrice();

        // Display Sauce
        System.out.println("Sauce:");
        sauce.display();
        totalPrice += sauce.getPrice();

        // Display Toppings, if any
        if (toppings != null && !toppings.isEmpty()) {
            System.out.println("Toppings:");
            for (Toppings topping : toppings) {
                topping.display();
                totalPrice += topping.getPrice();
            }
        }

        System.out.println("-------------------------");
        System.out.printf("Total Price: $%.2f\n", totalPrice);
    }

    // Getters and setters if needed
    public Crusts getCrust() {
        return crust;
    }

    public void setCrust(Crusts crust) {
        this.crust = crust;
    }

    public Sauces getSauce() {
        return sauce;
    }

    public void setSauce(Sauces sauce) {
        this.sauce = sauce;
    }

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }
}