package com.prog02.pizza_burger.pizza.toppings;

public class CheeseGruyere extends CheeseTopping { 
    public CheeseGruyere(double price) {
        super(price);
    }

    public CheeseGruyere() {
        super(7.25);
    }
    @Override
    public String toString() {
        return "Gruyere Cheese";
    }
    
}
