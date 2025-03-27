package com.prog02.pizza_burger.burger.bun;
import com.prog02.pizza_burger.common.Priceable;


abstract public class BurgerBun extends Priceable {
    protected String itemName;
    protected double price;
    protected boolean isToasted;


    @Override
    abstract public String toString();

    public BurgerBun(String itemName, double price, boolean isToasted) {
        super(price, itemName);
        this.itemName = itemName;
        this.price = price;
        this.isToasted = isToasted;
    }

    public BurgerBun(String itemName, boolean isToasted) {
        this(itemName, 3.00, isToasted);
    }

    protected String getStrPrice() {
        return String.format("%.2f", this.price);
    }

    public String toNiceString() {
        return toString() + "\n" + "Price -- $" + getStrPrice();
    }

}
