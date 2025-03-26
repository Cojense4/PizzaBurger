package com.prog02.pizza_burger.pizza.crust;
public class CrustThin extends PizzaCrust {
    public CrustThin(String ingredient) {
        super(ingredient, 3.00);
    }

    @Override
    public String toString() {
        return "Thin Crust made with " + this.ingredient;
    }
    
}
