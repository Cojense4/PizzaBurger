package com.prog02.pizza_burger.pizza.toppings;

public class CheeseMozzerella extends CheeseTopping {  
    public CheeseMozzerella() {
        super(5.50);
    }

    public CheeseMozzerella(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Mozzerella Cheese";
    }
    
}
