package com.gildedrose;

import com.gildedrose.strategy.ConjuredQuality;
import com.gildedrose.strategy.NormalItemSellIn;

public class Conjured extends InnItem {

    public Conjured() {
        this.updateQualityBehaviour = new ConjuredQuality();
        this.updateSellInBehaviour = new NormalItemSellIn();
    }
}
