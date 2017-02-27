package com.gildedrose;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

	private static final String GENERIC_ITEM_NAME = "foo";
	private static final String ITEM_NAME_AGED_BRIE = "Aged Brie";
	private static final String ITEM_NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String ITEM_NAME_BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static final String ITEM_NAME_CONJURE = "Conjured";

	@Test
	public void quality_should_degrade_by_1_when_sell_date_has_not_passed() {

		Item[] items = new Item[]{new Item(GENERIC_ITEM_NAME, 1, 6)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(5, items[0].quality);
		assertEquals(0, items[0].sellIn);
	}

	@Test
	public void quality_should_degrade_by_2_when_sell_date_has_passed() {

		Item[] items = new Item[]{new Item(GENERIC_ITEM_NAME, 0, 6)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(4, items[0].quality);
	}

	@Test
	public void quality_should_never_be_negative() {

		Item[] items = new Item[]{new Item(GENERIC_ITEM_NAME, 0, 0)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(0, items[0].quality);
	}

	@Test
	public void aged_brie_quality_should_increase_by_1() {

		Item[] items = new Item[]{new Item(ITEM_NAME_AGED_BRIE, 5, 6)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(7, items[0].quality);
	}

	@Test
	public void quality_should_never_be_more_than_50() {

		Item[] items = new Item[]{new Item(ITEM_NAME_AGED_BRIE, 5, 50)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(50, items[0].quality);
	}

	@Test
	public void sulfuras_sell_in_sould_not_be_changed() {

		Item[] items = new Item[]{new Item(ITEM_NAME_SULFURAS, 5, 10)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(5, items[0].sellIn);
	}

	@Test
	public void sulfuras_quality_should_be_80_always() {

		Item[] items = new Item[]{new Item(ITEM_NAME_SULFURAS, 5, 10)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(80, items[0].quality);
	}

	@Test
	public void backstage_passes_quality_should_increase_by_2_when_sell_in_is_between_6_and_10() {

		IntStream.rangeClosed(6,10).forEach( sellIn -> {

			Item[] items = new Item[]{new Item(ITEM_NAME_BACKSTAGE, sellIn, 6)};
			GildedRose app = new GildedRose(items);

			app.updateQuality();

			assertEquals(8, items[0].quality);
		});
	}

	@Test
	public void backstage_passes_quality_should_increase_by_3_when_sell_in_is_between_1_and_5() {

		IntStream.rangeClosed(1,5).forEach( sellIn -> {

			Item[] items = new Item[]{new Item(ITEM_NAME_BACKSTAGE, sellIn, 6)};
			GildedRose app = new GildedRose(items);

			app.updateQuality();

			assertEquals(9, items[0].quality);
		});
	}

	@Test
	public void backstage_passes_quality_should_be_0_when_sell_in_has_passed() {

		Item[] items = new Item[]{new Item(ITEM_NAME_BACKSTAGE, 0, 6)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(0, items[0].quality);
	}

	@Test
	public void backstage_passes_quality_should_increase_by_1_when_sell_in_is_between_greater_than_10() {

		Item[] items = new Item[]{new Item(ITEM_NAME_BACKSTAGE, 11, 6)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(7, items[0].quality);
	}

	@Test
	public void conjured_quality_should_degrade_by_2 () {

		Item[] items = new Item[]{new Item(ITEM_NAME_CONJURE, 5, 6)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(4, items[0].quality);

	}

}
