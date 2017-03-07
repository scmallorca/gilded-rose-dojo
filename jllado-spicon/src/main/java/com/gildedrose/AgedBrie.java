package com.gildedrose;

/**
 * Created by jllado on 6/03/17.
 */
public class AgedBrie implements InnItem {

    private final Normal item;

    public AgedBrie(final Item item) {
        this.item = new Normal(item);
    }

    @Override
    public void updateQuality() {
        item.increaseQuality();
        item.decreaseSellIn();
        if (item.sellDateHasPassed()) {
            item.increaseQuality();
        }
    }

}
