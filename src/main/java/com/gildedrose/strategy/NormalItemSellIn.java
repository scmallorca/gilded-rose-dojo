package com.gildedrose.strategy;

import com.gildedrose.Item;

public class NormalItemSellIn implements UpdateSellInBehaviour {
    @Override
    public int update(Item item) {
        return -1;
    }
}
