package com.prog02.pizza_burger.pizza.toppings;

public class VeggieOlive extends VeggieTopping {
    public VeggieOlive(double price) {
        super(price);
    }

    public VeggieOlive() {
        super(1.25);
    }

    @Override
    public String toString() {
        return "Black Olive";
    }
    
}
