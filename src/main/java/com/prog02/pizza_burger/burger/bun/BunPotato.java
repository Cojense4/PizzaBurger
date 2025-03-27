package com.prog02.pizza_burger.burger.bun;

public class BunPotato extends BurgerBun{
    public BunPotato(boolean isToasted) { super("Potato", 3.25, isToasted); }
    // Optional no input instantiation of BunPotato object
    public BunPotato() { super("Potato", 3.25, true); }

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
//        BunPotato bun = new BunPotato(false);
//        System.out.println(bun.getParentNiceString());
//    }
}