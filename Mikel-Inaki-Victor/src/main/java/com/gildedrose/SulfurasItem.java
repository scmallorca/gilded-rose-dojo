package com.gildedrose;

public class SulfurasItem extends GenericItem {

	private static final int SULFURAS_DEFAULT_QUALITY = 80;

	public SulfurasItem(String name, int sellIn) {
		super(name, sellIn, SULFURAS_DEFAULT_QUALITY);
	}

	@Override
	protected void updateQuality() {
		// Do nothing
	}

	@Override
	protected void updateSellIn() {
		// Do nothing
	}

	@Override
	protected void controlQualityLimits() {
		// Do nothing
	}
}
