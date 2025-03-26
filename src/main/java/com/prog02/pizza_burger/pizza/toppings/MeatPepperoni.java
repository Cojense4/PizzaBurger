package com.prog02.pizza_burger.pizza.toppings;

public class MeatPepperoni extends MeatTopping { 
    public MeatPepperoni(double price) {
        super(price);
    }

    public MeatPepperoni() {
        super(6.00);
    }

    @Override
    public String toString() {
        return "Pepperoni Meat";
    }
    
}
