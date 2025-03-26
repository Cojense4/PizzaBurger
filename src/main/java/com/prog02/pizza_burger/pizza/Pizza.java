package com.prog02.pizza_burger.pizza;

import com.prog02.pizza_burger.pizza.crust.*;
import com.prog02.pizza_burger.pizza.sauce.*;
import com.prog02.pizza_burger.pizza.toppings.*;
import com.prog02.pizza_burger.common.*;

import java.util.ArrayList;

public class Pizza {
    private PizzaCrust crust;
    private PizzaSauce sauce;
    private ArrayList<PizzaTopping> toppings;
    private ArrayList<ArrayList<MenuItem>> selectedItems;

    // Default constructor: create a pizza with default parts.
    public Pizza() {
        // Set default components.
        this.crust = new CrustThin("Flour");
        this.sauce = new SauceTraditional();
        this.toppings = new ArrayList<>();
    }

    // Constructor with selected crust, sauce, and toppings.
    public Pizza(PizzaCrust crust, PizzaSauce sauce, ArrayList<PizzaTopping> toppings) {
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = toppings;
    }
    
    /**
     * Groups the pizza components (crust, sauce, toppings) into a single list
     * Called when you use the display() method.
     **/
    private void buildPizza() {
        selectedItems = new ArrayList<>();
        
        // Crust Grouping
        ArrayList<MenuItem> crustGroup = new ArrayList<>();
        if (crust != null) {
            crustGroup.add((MenuItem) crust);
        }
        selectedItems.add(crustGroup);
        
        // Sauce Grouping
        ArrayList<MenuItem> sauceGroup = new ArrayList<>();
        if (sauce != null) {
            sauceGroup.add(sauce);
        }
        selectedItems.add(sauceGroup);
        
        // Toppings Grouping
        ArrayList<MenuItem> toppingGroup = new ArrayList<>();
        if (toppings != null) {
            toppingGroup.addAll(toppings);
        }
        selectedItems.add(toppingGroup);
    }
    
    /**
     * Displays the pizza build as a printed receipt.
     * This method will call buildPizza() to group the components.
     */
    public void display() {
        buildPizza();
        double totalPrice = 0.0;
        System.out.println("----- Pizza Receipt -----");
        
        // Display Crust
        if (crust != null) {
            System.out.println("Crust:");
            System.out.printf("- %s - Price: $%.2f\n", crust.toString(), crust.getPrice());
            totalPrice += crust.getPrice();
        }
        
        // Display Sauce
        if (sauce != null) {
            System.out.println("Sauce:");
            System.out.printf("- %s - Price: $%.2f\n", sauce.toString(), sauce.getPrice());
            totalPrice += sauce.getPrice();
        }
        
        // Display Toppings, if any
        if (toppings != null && !toppings.isEmpty()) {
            System.out.println("Toppings:");
            for (PizzaTopping topping : toppings) {
                System.out.printf(" - %s - Price: $%.2f\n", topping.toString(), topping.getPrice());
                totalPrice += topping.getPrice();
            }
        }
        System.out.println("-------------------------");
        System.out.printf("Total Price: $%.2f\n", totalPrice);
    }
    
    // Getters and Setters 
    public PizzaCrust getCrust() {
        return crust;
    }
    
    public void setCrust(PizzaCrust crust) {
        this.crust = crust;
    }
    
    public PizzaSauce getSauce() {
        return sauce;
    }
    
    public void setSauce(PizzaSauce sauce) {
        this.sauce = sauce;
    }
    
    public ArrayList<PizzaTopping> getToppings() {
        return toppings;
    }
    
    public void setToppings(ArrayList<PizzaTopping> toppings) {
        this.toppings = toppings;
    }
    
    public void addTopping(PizzaTopping topping) {
        this.toppings.add(topping);
    }
    

}
