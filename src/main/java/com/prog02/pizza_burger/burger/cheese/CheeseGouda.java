package com.prog02.pizza_burger.burger.cheese;

public class CheeseGouda extends BurgerCheese{
    public CheeseGouda(boolean isSmoked, boolean isAged) { super("Gouda Cheese", 0.75, isSmoked, isAged); }
    public CheeseGouda() { super("Gouda Cheese", 0.75, false, false); }

    @Override
    public String toString() {
        // Make sure that 'itemName' is properly defined in BurgerBun
        return (isSmoked ? "Smoked " : "") + (isAged ? "Aged " : "") + this.itemName + " Slice";
    }

//    public String getParentNiceString() {
//        return super.toNiceString();
//    }
//
//    // Temporary main method for testing
//    public static void main(String[] args) {
//        CheeseGouda cheese = new CheeseGouda();
//        CheeseGouda cheese2 = new CheeseGouda(true, true);
//        CheeseGouda cheese3 = new CheeseGouda(true, false);
//        System.out.println(cheese.getParentNiceString());
//        System.out.println(cheese2.getParentNiceString());
//        System.out.println(cheese3.getParentNiceString());
//    }
}
