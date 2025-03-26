package com.prog02.pizza_burger.burger.patty;
import com.prog02.pizza_burger.common.Priceable;

abstract public class BurgerPatty extends Priceable {
    protected String itemType;
    protected double price;
    // cookLevel is the rare to well-done variable where it ranges from 1=rare=125 degrees to 5=well done=165 degrees
    protected int cookLevel;
    // seasonLevel is the amount of seasonings wanted for the burger patty (0 to 3)
    protected int seasonLevel;


    @Override
    abstract public String toString();

    public BurgerPatty(String itemType, double price, int cookLevel, int seasonLevel) {
        super(price);
        this.seasonLevel = seasonLevel;
        this.price = price;
        this.itemType = itemType;
        this.cookLevel = cookLevel;
    }
    public BurgerPatty(String itemType) { this(itemType, 0.50, 2, 0); }

    public double calcPrice() {
        if (this.seasonLevel > 3) {
            this.seasonLevel = 3;
        }
        return this.price + (this.seasonLevel * 0.25);
    };

//    abstract public int getCookTemp();

    public String seasoningLevel() {
        return switch(this.seasonLevel) {
            case 1: {
                yield "Light seasonings";
            }
            case 2: {
                yield "Well seasoned";
            }
            case 3: {
                yield "Extra seasoning";
            }
            default: {
                yield "No seasonings";
            }
        };
    }

    public String getCookLevel() {
        return switch(this.cookLevel) {
            case 1 -> "Rare";
            case 2 -> "Medium Rare";
            case 4 -> "Medium-Well";
            case 5 -> "Well Done";
            default -> "Medium";
        };
    }

    protected String getStrPrice() {
        return String.format("%.2f", this.price);
    }

    public String toNiceString() {
        return toString() + "\n" + "Cooked to " + getCookLevel() + " Temp\n" + "Price -- $" + getStrPrice();
    }
}
