package com.prog02.pizza_burger.burger.bun;

public class BunSourdough extends BurgerBun {
    public BunSourdough(boolean isToasted) { super("Sourdough", 4.25, isToasted); }
    // Optional no input instantiation of BunSourdough object
    public BunSourdough() { super("Sourdough", 4.25, true); }

    @Override
    public String toString() {
        // Make sure that 'isToasted' and 'itemName' are properly defined in BurgerBun
        return (isToasted ? "Toasted " : "Untoasted ") + this.itemName + " Bun";
    }

//    public String getParentNiceString() {
//        return super.toNiceString();
//    }
//
//    // Temporary main method for testing
//    public static void main(String[] args) {
//        BunSourdough bun = new BunSourdough();
//        System.out.println(bun.getParentNiceString());
//    }
}
