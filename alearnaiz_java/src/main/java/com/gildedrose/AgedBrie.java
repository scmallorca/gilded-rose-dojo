package com.gildedrose;

import com.gildedrose.strategy.AgedBrieQuality;
import com.gildedrose.strategy.NormalItemSellIn;

public class AgedBrie extends InnItem {

    public AgedBrie() {
        this.updateQualityBehaviour = new AgedBrieQuality();
        this.updateSellInBehaviour = new NormalItemSellIn();
    }
}
