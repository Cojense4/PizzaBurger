package com.prog02.pizza_burger.model.pizza;

import com.prog02.pizza_burger.model.common.AbstractMenuItem;

import java.util.ArrayList;

public class Pizza extends AbstractMenuItem {
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
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------- Pizza ----------\n");
        // crust
        sb.append(crust.display()).append("\n");
        // sauce
        sb.append(sauce.display()).append("\n");
        // toppings
        if (toppings != null && !toppings.isEmpty()) {
            sb.append("Toppings:\n");
            for (Topping topping : toppings) {
                sb.append(topping.display()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        totalPrice += crust.getPrice();
        totalPrice += sauce.getPrice();
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }
        return totalPrice;
    }

}