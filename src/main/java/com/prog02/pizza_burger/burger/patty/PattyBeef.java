package com.prog02.pizza_burger.burger.patty;

public class PattyBeef extends BurgerPatty {
    public PattyBeef(int cookLevel, int seasonLevel) {
        super("Beef", 5.00, cookLevel, seasonLevel);
        this.price = super.calcPrice();
    }

    @Override
    public String toString(){
        return super.seasoningLevel() + " " + this.itemType + " patty";
    }

//    public String getParentNiceString() {
//        return super.toNiceString();
//    }
//
//    // Temporary main method for testing
//    public static void main(String[] args) {
//        PattyBeef patty1 = new PattyBeef(1, 1);
//        PattyBeef patty2 = new PattyBeef(2, 2);
//        PattyBeef patty3 = new PattyBeef(3, 3);
//        PattyBeef patty4 = new PattyBeef(4, 4);
//        System.out.println(patty1.getParentNiceString());
//        System.out.println(patty2.getParentNiceString());
//        System.out.println(patty3.getParentNiceString());
//        System.out.println(patty4.getParentNiceString());
//
//    }
}
