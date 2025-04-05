package com.prog02.pizza_burger.model.pizza;

import com.prog02.pizza_burger.model.common.AbstractMenuItem;
import com.prog02.pizza_burger.model.common.Priceable;
import com.prog02.pizza_burger.model.common.PriceableWrapper;

import java.util.ArrayList;

public class Pizza extends AbstractMenuItem {
    private String itemName;
    private Crust crust;
    private ArrayList<Sauce> sauces;
    private ArrayList<Topping> toppings;

    // Constructor taking the enums.
    public Pizza(Crust crust, ArrayList<Sauce> sauces, ArrayList<Topping> toppings) {
        this.crust = crust;
        this.sauces = sauces;
        this.toppings = toppings;
        this.price = getPrice();
    }

    /**
     * Displays the pizza build as a printed receipt.
     */
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("---------- %s ----------\n", itemName));
        // crust
        sb.append(crust.display()).append("\n");
        // sauces
        if (sauces != null && !sauces.isEmpty()) {
            for (Sauce sauce : sauces) {
                sb.append(sauce.display()).append("\n");
            }
        }
        // toppings
        if (toppings != null && !toppings.isEmpty()) {
            sb.append("--- Toppings ---\n");
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
        for (Sauce sauce : sauces) {
            totalPrice += sauce.getPrice();
        }
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }
        return totalPrice;
    }

    public Crust getCrust() { return crust; }
    public ArrayList<Sauce> getSauces() { return sauces; }
    public ArrayList<Topping> getToppings() { return toppings; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setCrust(Crust newCrust) { this.crust = newCrust; }
    public void setSauces(ArrayList<Sauce> newSauces) { this.sauces = newSauces; }
    public void setToppings(ArrayList<Topping> newToppings) { this.toppings = newToppings; }


    /**
     * Returns a sorted list of all Pizza components (crust, sauces, and toppings) based on their price.
     * Components are sorted in ascending order (lowest price first).
     */
    public ArrayList<Priceable> getSortedComponents() {
        ArrayList<Priceable> components = new ArrayList<>();
        if (crust != null) {
            components.add(new PriceableWrapper(crust));
        }
        if (sauces != null) {
            for (Sauce sauce : sauces) {
                components.add(new PriceableWrapper(sauce));
            }
        }
        if (toppings != null) {
            for (Topping topping : toppings) {
                components.add(new PriceableWrapper(topping));
            }
        }
        components.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        return components;
    }
    /* Getters and Setters
    For use to modify the burger (through BurgerTemplate)
     */

}