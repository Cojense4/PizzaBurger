package com.prog02.pizza_burger.pizza.sauce;
public class SauceAlfredo extends PizzaSauce {
    
    public SauceAlfredo(double price) {
        super(price);
    }

    public SauceAlfredo() {
        super(5.00);
    }

    @Override
    public String toString() {
        return "Alfredo Sauce";
    }
    
}
