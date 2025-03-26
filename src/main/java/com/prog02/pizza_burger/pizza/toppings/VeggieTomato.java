package com.prog02.pizza_burger.pizza.toppings;

public class VeggieTomato extends VeggieTopping { 
    public VeggieTomato(double price) {
        super(price);
    }

    public VeggieTomato() {
        super(1.25);
    }

    @Override
    public String toString() {
        return "Sun Dried Tomatoes";
    }
    
}
