package com.prog02.pizza_burger.burger.cheese;

public class CheeseAmerican extends BurgerCheese {
    private final boolean isWhite;

    public CheeseAmerican(boolean isWhite, boolean isSmoked, boolean isAged) {
        super("American Cheese", 0.50, isSmoked, isAged);
        this.isWhite = isWhite;
    }

    public CheeseAmerican(boolean isWhite) {
        super("American Cheese", 0.50, false, false);
        this.isWhite = isWhite;
    }

    @Override
    public String toString() {
        // Make sure that 'itemName' is properly defined in BurgerBun
        return (isSmoked ? "Smoked " : "") + (isAged ? "Aged " : "") + (isWhite ? "White ": "") + this.itemName + " Slice";
    }

//   public String getParentNiceString() {
//        return super.toNiceString();
//    }
//
//    // Temporary main method for testing
//    public static void main(String[] args) {
//        CheeseAmerican cheese = new CheeseAmerican(false);
//        System.out.println(cheese.getParentNiceString());
//    }
}