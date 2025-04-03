
package com.prog02.pizza_burger.model.common;

import com.prog02.pizza_burger.model.common.MenuItem;

/**
 * A wrapper class that adapts a MenuItem to Priceable.
 */
public class PriceableWrapper extends Priceable {
    private final MenuItem item;

    public PriceableWrapper(MenuItem item) {
        // Call the Priceable constructor using the item's price and name.
        super(item.getPrice(), item.getName());
        this.item = item;
    }

    // Optionally, delegate additional methods if needed.
}