package com.prog02.pizza_burger.model.pizza;

import com.prog02.pizza_burger.model.common.AbstractMenuItem;
import com.prog02.pizza_burger.model.common.Priceable;
import com.prog02.pizza_burger.model.common.PriceableWrapper;

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
    /**
     * Returns a sorted list of all Pizza components (crust, sauce, and toppings) based on their price.
     * Components are sorted in ascending order (lowest price first).
     */
    public ArrayList<Priceable> getSortedComponents() {
        ArrayList<Priceable> components = new ArrayList<>();
        if (crust != null) {
            components.add(new PriceableWrapper(crust));
        }
        if (sauce != null) {
            components.add(new PriceableWrapper(sauce));
        }
        if (toppings != null) {
            for (Topping topping : toppings) {
                components.add(new PriceableWrapper(topping));
            }
        }
        components.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        return components;
    }

}