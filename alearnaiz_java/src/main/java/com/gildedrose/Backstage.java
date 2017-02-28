package com.gildedrose;

import com.gildedrose.strategy.BackstageQuality;
import com.gildedrose.strategy.NormalItemSellIn;

public class Backstage extends InnItem {

    public Backstage() {
        this.updateQualityBehaviour = new BackstageQuality();
        this.updateSellInBehaviour = new NormalItemSellIn();
    }
}
