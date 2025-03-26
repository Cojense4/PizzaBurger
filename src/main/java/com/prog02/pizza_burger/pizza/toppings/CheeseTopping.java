package com.prog02.pizza_burger.pizza.toppings;

public class CheeseTopping extends PizzaTopping {
    public CheeseTopping(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Cheese Topping";
    }
    
}