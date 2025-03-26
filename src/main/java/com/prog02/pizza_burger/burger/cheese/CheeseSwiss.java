package com.prog02.pizza_burger.burger.cheese;

public class CheeseSwiss extends BurgerCheese{
    public CheeseSwiss(boolean isSmoked, boolean isAged) { super("Swiss", 0.45, isSmoked, isAged); }
    public CheeseSwiss() { super("Swiss", 0.45, false, false); }

    @Override
    public String toString() {
        // Make sure that 'itemType' is properly defined in BurgerBun
        return (isSmoked ? "Smoked " : "") + (isAged ? "Aged " : "") + this.itemType + " Cheese Slice";
    }

    public String getParentNiceString() {
        return super.toNiceString();
    }

    // Temporary main method for testing
    public static void main(String[] args) {
        CheeseSwiss cheese = new CheeseSwiss();
        CheeseSwiss cheese2 = new CheeseSwiss(true, true);
        CheeseSwiss cheese3 = new CheeseSwiss(true, false);
        System.out.println(cheese.getParentNiceString());
        System.out.println(cheese2.getParentNiceString());
        System.out.println(cheese3.getParentNiceString());
    }
}
