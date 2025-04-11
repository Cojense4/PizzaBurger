package com.prog02.pizza_burger.model.common;

public interface MenuItem {
    double getPrice();
    String getName();
    default String display() { return getName() + " (" + String.format("%.2f",getPrice()) + ")"; }
    static <T extends Enum<T> & MenuItem> T fromItemName(Class<T> enumType, String itemName) {
        for (T item : enumType.getEnumConstants()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        // Returns the first enum constant as the default.
        return enumType.getEnumConstants()[0];
    }

    Long getId();
}