package com.prog02.pizza_burger.pizza.toppings;

public class VeggieTopping extends PizzaTopping { 
    public VeggieTopping(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Veggie Topping";
    }
    
}
