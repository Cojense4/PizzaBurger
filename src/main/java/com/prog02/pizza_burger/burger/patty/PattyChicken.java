package com.prog02.pizza_burger.burger.patty;

public class PattyChicken  extends BurgerPatty {
    public PattyChicken(int cookLevel, int seasonLevel) {
        super("Chicken", 3.5, cookLevel, seasonLevel);
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
//        PattyChicken patty1 = new PattyChicken(1, 1);
//        PattyChicken patty2 = new PattyChicken(2, 2);
//        PattyChicken patty3 = new PattyChicken(3, 3);
//        PattyChicken patty4 = new PattyChicken(4, 0);
//        System.out.println(patty1.getParentNiceString());
//        System.out.println(patty2.getParentNiceString());
//        System.out.println(patty3.getParentNiceString());
//        System.out.println(patty4.getParentNiceString());
//
//    }
}
