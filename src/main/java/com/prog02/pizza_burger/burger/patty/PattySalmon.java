package com.prog02.pizza_burger.burger.patty;

public class PattySalmon extends BurgerPatty {
    public PattySalmon(int cookLevel, int seasonLevel) {
        super("Salmon", 7.75, cookLevel, seasonLevel);
        this.price = super.calcPrice();
    }

    @Override
    public String toString(){
        return super.seasoningLevel() + " " + this.itemName + " patty";
    }

//    public String getParentNiceString() {
//        return super.toNiceString();
//    }
//
//    // Temporary main method for testing
//    public static void main(String[] args) {
//        PattySalmon patty1 = new PattySalmon(1, 1);
//        PattySalmon patty2 = new PattySalmon(2, 2);
//        PattySalmon patty3 = new PattySalmon(3, 3);
//        PattySalmon patty4 = new PattySalmon(4, 0);
//        System.out.println(patty1.getParentNiceString());
//        System.out.println(patty2.getParentNiceString());
//        System.out.println(patty3.getParentNiceString());
//        System.out.println(patty4.getParentNiceString());
//
//    }
}
