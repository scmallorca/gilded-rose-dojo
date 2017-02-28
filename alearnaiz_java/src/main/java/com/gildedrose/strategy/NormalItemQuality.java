package com.gildedrose.strategy;

import com.gildedrose.Item;


public class NormalItemQuality implements UpdateQualityBehaviour {
    @Override
    public int update(Item item) {
        if (item.sellIn <= 0) {
            return -2;
        } else {
            return -1;
        }
    }
}
