package com.gildedrose;

public class BrieItem extends GenericItem {

	public BrieItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	protected void updateQuality() {
		quality++;
	}
}
