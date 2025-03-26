package com.prog02.pizza_burger.pizza.toppings;

public class CheeseAsiago extends CheeseTopping { 
    public CheeseAsiago(double price) {
        super(price);
    }

    public CheeseAsiago() {
        super(5.75);
    }

    @Override
    public String toString() {
        return "Asiago Cheese";
    }
    
}
