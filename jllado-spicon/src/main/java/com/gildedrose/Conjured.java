package com.gildedrose;

/**
 * Created by jllado on 7/03/17.
 */
public class Conjured implements InnItem {

    private final Normal item;

    public Conjured(final Item item) {
        this.item = new Normal(item);
    }

    @Override
    public void updateQuality() {
        decreaseQualityTwice();
        item.decreaseSellIn();
        if (item.sellDateHasPassed()) {
            decreaseQualityTwice();
        }
    }

    private void decreaseQualityTwice() {
        item.decreaseQuality();
        item.decreaseQuality();
    }
}
