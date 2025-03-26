package com.prog02.pizza_burger.pizza.toppings;

public class CheeseGouda extends CheeseTopping {
    public CheeseGouda(double price) {
        super(price);
    }
    
    public CheeseGouda() {
        super(6.50);
    }

    @Override
    public String toString() {
        return "Gouda Cheese";
    }
    
}
