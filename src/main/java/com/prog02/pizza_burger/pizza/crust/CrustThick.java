package com.prog02.pizza_burger.pizza.crust;

public class CrustThick extends PizzaCrust {
    private final boolean isDeepDish;
    
    public CrustThick(String ingredient, boolean isDeepDish) {
        super(ingredient);
        this.isDeepDish = isDeepDish;
        if (this.isDeepDish) {
            this.price = 7.00;
        } else {
            this.price = 6.00;
        }
    }

    @Override
    public String toString() {
        return (isDeepDish ? "Deep Dish " : "Thick ") + this.ingredient + " Crust";
    }

    
}
