package com.gildedrose;

/**
 * Created by jllado on 6/03/17.
 */
public class Backstage implements InnItem {

    private final Normal item;

    public Backstage(final Item item) {
        this.item = new Normal(item);
    }

    @Override
    public void updateQuality() {
        if (item.isSellInLessThan(11)) {
            item.increaseQuality();
        }
        if (item.isSellInLessThan(6)) {
            item.increaseQuality();
        }
        item.increaseQuality();
        item.decreaseSellIn();
        if (item.sellDateHasPassed()) {
            item.decreaseQualityToZero();
        }
    }

}
