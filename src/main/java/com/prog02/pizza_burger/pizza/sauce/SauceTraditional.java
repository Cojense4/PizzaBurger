package com.prog02.pizza_burger.pizza.sauce;
public class SauceTraditional extends PizzaSauce {

    public SauceTraditional(double price) {
        super(price);
    }
    
    public SauceTraditional() {
        super(4.50);
    }

    @Override
    public String toString() {
        return "Traditional Pizza Sauce";
    }
    
}
