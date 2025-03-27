package com.prog02.pizza_burger.pizza;

import com.prog02.pizza_burger.common.MenuItem;
import java.util.ArrayList;

public class Pizza {
    private PizzaCrusts crust;
    private PizzaSauces sauce;
    private ArrayList<PizzaToppings> toppings;

    // Constructor taking the enums.
    public Pizza(PizzaCrusts crust, PizzaSauces sauce, ArrayList<PizzaToppings> toppings) {
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
        System.out.println(crust.toNiceString());
        totalPrice += crust.getPrice();

        // Display Sauce
        System.out.println("Sauce:");
        System.out.println(sauce.toNiceString());
        totalPrice += sauce.getPrice();

        // Display Toppings, if any
        if (toppings != null && !toppings.isEmpty()) {
            System.out.println("Toppings:");
            for (PizzaToppings topping : toppings) {
                System.out.println(topping.toNiceString());
                totalPrice += topping.getPrice();
            }
        }

        System.out.println("-------------------------");
        System.out.printf("Total Price: $%.2f\n", totalPrice);
    }

    // Getters and setters if needed
    public PizzaCrusts getCrust() {
        return crust;
    }

    public void setCrust(PizzaCrusts crust) {
        this.crust = crust;
    }

    public PizzaSauces getSauce() {
        return sauce;
    }

    public void setSauce(PizzaSauces sauce) {
        this.sauce = sauce;
    }

    public ArrayList<PizzaToppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<PizzaToppings> toppings) {
        this.toppings = toppings;
    }
}