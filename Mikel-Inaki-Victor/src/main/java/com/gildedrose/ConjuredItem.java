package com.gildedrose;

public class ConjuredItem extends GenericItem {
	public ConjuredItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	protected void updateQuality() {
		quality -= 2;
	}
}
