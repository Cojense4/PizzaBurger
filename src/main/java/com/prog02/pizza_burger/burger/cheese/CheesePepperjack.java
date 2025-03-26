package com.prog02.pizza_burger.burger.cheese;

public class CheesePepperjack extends BurgerCheese{
    public CheesePepperjack(boolean isSmoked, boolean isAged) { super("Pepperjack", 0.55, isSmoked, isAged); }
    public CheesePepperjack() { super("Pepperjack", 0.55, false, false); }

    @Override
    public String toString() {
        // Make sure that 'itemType' is properly defined in BurgerBun
        return (isSmoked ? "Smoked " : "") + (isAged ? "Aged " : "") + this.itemType + " Cheese Slice";
    }

//    public String getParentNiceString() {
//        return super.toNiceString();
//    }
//
//    // Temporary main method for testing
//    public static void main(String[] args) {
//        CheesePepperjack cheese = new CheesePepperjack();
//        CheesePepperjack cheese2 = new CheesePepperjack(true, true);
//        CheesePepperjack cheese3 = new CheesePepperjack(true, false);
//        System.out.println(cheese.getParentNiceString());
//        System.out.println(cheese2.getParentNiceString());
//        System.out.println(cheese3.getParentNiceString());
//    }
}
