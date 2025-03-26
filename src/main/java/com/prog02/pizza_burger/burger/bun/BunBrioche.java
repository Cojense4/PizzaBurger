package com.prog02.pizza_burger.burger.bun;

public class BunBrioche extends BurgerBun {

    public BunBrioche(boolean isToasted) { super("Brioche", 3.50, isToasted); }
    // Optional no input instantiation of BunBrioche object
    public BunBrioche() { super("Brioche", 3.50, true); }

    @Override
    public String toString() {
        // Make sure that 'isToasted' and 'itemType' are properly defined in BurgerBun
        return (isToasted ? "Toasted " : "Untoasted ") + this.itemType + " Bun";
    }

//    public String getParentNiceString() {
//        return super.toNiceString();
//    }
//
//    // Temporary main method for testing
//    public static void main(String[] args) {
//        BunBrioche bun = new BunBrioche();
//        System.out.println(bun.getParentNiceString());
//    }
}