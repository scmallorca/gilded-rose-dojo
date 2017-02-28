package com.gildedrose;

import com.gildedrose.strategy.UpdateQualityBehaviour;
import com.gildedrose.strategy.UpdateSellInBehaviour;

public abstract class InnItem {

    public static final int MAX_QUALITY = 50;

    UpdateQualityBehaviour updateQualityBehaviour;

    UpdateSellInBehaviour updateSellInBehaviour;

    final void update(Item item) {
        int quality = updateQualityBehaviour.update(item);
        int sellIn = updateSellInBehaviour.update(item);
        if (quality != 0) {
            item.quality = item.quality + quality;
            if (item.quality > MAX_QUALITY) {
                item.quality = MAX_QUALITY;
            }

            if (item.quality < 0) {
                item.quality = 0;
            }
        }
        item.sellIn = item.sellIn + sellIn;
    }

    public void setUpdateQualityBehaviour(UpdateQualityBehaviour updateQualityBehaviour) {
        this.updateQualityBehaviour = updateQualityBehaviour;
    }

    public void setUpdateSellInBehaviour(UpdateSellInBehaviour updateSellInBehaviour) {
        this.updateSellInBehaviour = updateSellInBehaviour;
    }

}
