package com.gildedrose.strategy;


import com.gildedrose.Item;

public class ConjuredQuality implements UpdateQualityBehaviour {
    @Override
    public int update(Item item) {
        NormalItemQuality normalItemQuality = new NormalItemQuality();
        return normalItemQuality.update(item) * 2;
    }
}
