package com.prog02.pizza_burger.burger.bun;

public class BunSesame extends BurgerBun {
    public BunSesame(boolean isToasted) { super("Sesame", 3.00, isToasted); }
    // Optional no input instantiation of BunSesame object
    public BunSesame() { super("Sesame", 3.00, true); }

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
//        BunSesame bun = new BunSesame();
//        System.out.println(bun.getParentNiceString());
//    }
}