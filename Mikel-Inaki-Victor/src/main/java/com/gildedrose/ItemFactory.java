package com.gildedrose;

public class ItemFactory {

	private static final String ITEM_NAME_AGED_BRIE = "Aged Brie";
	private static final String ITEM_NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String ITEM_NAME_BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static final String ITEM_NAME_CONJURE = "Conjured";

	public static GenericItem createItem(Item item) {

		GenericItem genericItem;

		switch (item.name) {

			case ITEM_NAME_AGED_BRIE:
				genericItem = new BrieItem(item.name, item.sellIn, item.quality);
				break;

			case ITEM_NAME_BACKSTAGE:
				genericItem = new BackstageItem(item.name, item.sellIn, item.quality);
				break;

			case ITEM_NAME_SULFURAS:
				genericItem = new SulfurasItem(item.name, item.sellIn);
				break;

			case ITEM_NAME_CONJURE:
				genericItem = new ConjuredItem(item.name, item.sellIn, item.quality);
				break;

			default:
				genericItem = new GenericItem(item.name, item.sellIn, item.quality);
				break;
		}

		return genericItem;
	}
}
