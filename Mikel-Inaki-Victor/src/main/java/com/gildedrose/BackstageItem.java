package com.gildedrose;

public class BackstageItem extends BrieItem {
	public BackstageItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	protected void updateQuality() {

		if (sellIn >= 6 && sellIn <= 10) {
			quality += 2;
		}
		else if (sellIn >= 1 && sellIn <= 5) {
			quality += 3;
		}
		else if (sellIn == 0) {
			quality = 0;
		}
		else {
			super.updateQuality();
		}
	}
}
