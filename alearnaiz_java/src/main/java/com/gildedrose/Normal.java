package com.gildedrose;

import com.gildedrose.strategy.NormalItemQuality;
import com.gildedrose.strategy.NormalItemSellIn;

public class Normal extends InnItem {

    public Normal() {
        this.updateQualityBehaviour = new NormalItemQuality();
        this.updateSellInBehaviour = new NormalItemSellIn();
    }
}
