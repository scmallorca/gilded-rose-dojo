package com.gildedrose;

public class GenericItem extends Item {

	private static final int LIMIT_QUALITY_MIN = 0;
	private static final int LIMIT_QUALITY_MAX = 50;

	GenericItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	GenericItem updateItem() {

		updateQuality();

		controlQualityLimits();

		updateSellIn();

		return this;
	}

	protected void updateQuality() {

		if (sellIn > 0) {
			quality--;
		} else {
			quality -= 2;
		}
	}

	protected void controlQualityLimits() {

		if (quality < LIMIT_QUALITY_MIN) {
			quality = LIMIT_QUALITY_MIN;
		}

		if (quality > LIMIT_QUALITY_MAX) {
			quality = LIMIT_QUALITY_MAX;
		}
	}

	protected void updateSellIn() {
		sellIn--;
	}

}
