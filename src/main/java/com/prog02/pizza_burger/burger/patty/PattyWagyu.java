package com.prog02.pizza_burger.burger.patty;

public class PattyWagyu extends BurgerPatty {
    public PattyWagyu(int cookLevel, int seasonLevel) {
        super("Wagyu", 10, cookLevel, seasonLevel);
        this.price = super.calcPrice();
    }

    @Override
    public String toString(){
        return super.seasoningLevel() + " " + this.itemType + " patty";
    }

    public String getParentNiceString() {
        return super.toNiceString();
    }

    // Temporary main method for testing
    public static void main(String[] args) {
        PattyWagyu patty1 = new PattyWagyu(1, 1);
        PattyWagyu patty2 = new PattyWagyu(2, 2);
        PattyWagyu patty3 = new PattyWagyu(3, 3);
        PattyWagyu patty4 = new PattyWagyu(4, 4);
        System.out.println(patty1.getParentNiceString());
        System.out.println(patty2.getParentNiceString());
        System.out.println(patty3.getParentNiceString());
        System.out.println(patty4.getParentNiceString());

    }
}
