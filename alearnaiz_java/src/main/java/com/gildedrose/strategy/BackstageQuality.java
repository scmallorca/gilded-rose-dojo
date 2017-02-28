package com.gildedrose.strategy;


import com.gildedrose.Item;

public class BackstageQuality implements UpdateQualityBehaviour {
    @Override
    public int update(Item item) {
        int count = 1;

        if (item.sellIn < 11) {
            count = count + 1;
        }

        if (item.sellIn < 6) {
            count = count + 1;
        }

        if (item.sellIn <= 0) {
            // Quality is going to be 0
            count = item.quality * (-1);
        }

        return count;
    }
}
