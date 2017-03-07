package com.gildedrose;

/**
 * Created by jllado on 6/03/17.
 */
public class Normal implements InnItem {

    public static final int MINIMUM_QUALITY = 0;
    public static final int MAXIMUM_QUALITY = 50;
    private final Item item;

    public Normal(final Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        decreaseSellIn();
        if (sellDateHasPassed()) {
            decreaseQuality();
        }
    }

    public boolean isSellInLessThan(final int days) {
        return item.sellIn < days;
    }

    public boolean sellDateHasPassed() {
        return item.sellIn < 0;
    }

    public void increaseQuality() {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    public void decreaseQuality() {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    public void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    public void decreaseQualityToZero() {
        item.quality = 0;
    }
}
