package com.prog02.pizza_burger.model.pizza;

import java.util.ArrayList;

public class Pizza {
    private Crust crust;
    private Sauce sauce;
    private ArrayList<Topping> toppings;

    // Constructor taking the enums.
    public Pizza(Crust crust, Sauce sauce, ArrayList<Topping> toppings) {
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

        // Display Topping, if any
        if (toppings != null && !toppings.isEmpty()) {
            System.out.println("Topping:");
            for (Topping topping : toppings) {
                topping.display();
                totalPrice += topping.getPrice();
            }
        }

        System.out.println("-------------------------");
        System.out.printf("Total Price: $%.2f\n", totalPrice);
    }

    // Getters and setters if needed
    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }
}