package com.prog02.pizza_burger.pizza.toppings;

public class MeatBacon extends MeatTopping {
    public MeatBacon(double price) {
        super(price);
    }

    public MeatBacon() {
        super(7.00);
    }
    
    @Override
    public String toString() {
        return "Bacon Meat";
    }
    
}
