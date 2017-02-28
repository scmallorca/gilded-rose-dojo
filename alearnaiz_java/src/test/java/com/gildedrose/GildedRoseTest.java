package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {


    private GildedRose updateQuality(Item[] items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }

    @Test
    public void normalItemPositiveSellIn_QualityDecreaseByOne() {
        int quality = 40;
        Item[] items = new Item[] { new Item("foo", 10, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality-1, app.items[0].quality);
    }

    @Test
    public void normalItemZeroOrLessSellIn_QualityDecreaseByTwo() {
        int quality = 10;
        Item[] items = new Item[] { new Item("foo", 0, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality-2, app.items[0].quality);
    }

    @Test
    public void items_SellInDecreaseByOne() {
        int sellInNormalItem = -1;
        int sellInAgedBrie = 50;
        int sellInBackstagePasses = 0;
        int sellInConjured = 45;
        Item[] items = new Item[] {
            new Item("foo", sellInNormalItem, 10),
            new Item("Aged Brie", sellInAgedBrie, 11),
            new Item("Backstage passes to a TAFKAL80ETC concert", sellInBackstagePasses, 9),
            new Item("Conjured", sellInConjured, 9),
        };
        GildedRose app = updateQuality(items);
        assertEquals(sellInNormalItem-1, app.items[0].sellIn);
        assertEquals(sellInAgedBrie-1, app.items[1].sellIn);
        assertEquals(sellInBackstagePasses-1, app.items[2].sellIn);
        assertEquals(sellInConjured-1, app.items[3].sellIn);
    }

    @Test
    public void qualityIsNeverNegative() {
        int quality = 0;
        Item[] items = new Item[] { new Item("foo", -1, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality, app.items[0].quality);
    }

    @Test
    public void agedBriePositiveSellIn_QualityIncreaseByOne() {
        int quality = 40;
        Item[] items = new Item[] { new Item("Aged Brie", 1, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality+1, app.items[0].quality);

    }

    @Test
    public void agedBrieZeroOrLessSellIn_QualityIncreaseByTwo() {
        int quality = 40;
        Item[] items = new Item[] { new Item("Aged Brie", 0, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality+2, app.items[0].quality);

    }

    @Test
    public void allItemsNeverIncreaseQualityMoreThanFifty() {
        int quality = 50;
        Item[] items = new Item[] {
            new Item("Aged Brie", 8, quality),
            new Item("Backstage passes to a TAFKAL80ETC concert", 7, quality),
        };
        GildedRose app = updateQuality(items);
        assertEquals(quality, app.items[0].quality);
        assertEquals(quality, app.items[1].quality);
    }

    @Test
    public void sulfurasNeverDecreaseQuality() {
        int quantity = 20;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 8, quantity) };
        GildedRose app = updateQuality(items);
        assertEquals(quantity, app.items[0].quality);
    }

    @Test
    public void sulfurasNeverDecreaseSellIn() {
        int sellIn = 20;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, 7) };
        GildedRose app = updateQuality(items);
        assertEquals(sellIn, app.items[0].sellIn);
    }

    @Test
    public void backstagePassesSellInMoreThanTen_QualityIncreaseByOne() {
        int quality = 20;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality+1, app.items[0].quality);
    }

    @Test
    public void backstagePassesSellInBetweenTenAndSix_QualityIncreaseByTwo() {
        int quality = 20;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality+2, app.items[0].quality);
    }

    @Test
    public void backstagePassesSellInLBetweenFiveAndOne_QualityIncreaseByThree() {
        int quality = 46;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality+3, app.items[0].quality);
    }

    @Test
    public void backstagePassesZeroOrLessSellIn_QualityIsZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = updateQuality(items);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void conjuredPositiveSellIn_QualityDecreaseByTwo() {
        int quality = 20;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 1, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality-2, app.items[0].quality);
    }

    @Test
    public void conjuredZeroOrNegativeSellIn_QualityDecreaseByFour() {
        int quality = 20;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality-4, app.items[0].quality);
    }

    @Test
    public void normalItemZeroOrLessQuality_SellInDecreaseByOne() {
        int sellIn = 20;
        Item[] items = new Item[] { new Item("foo", sellIn, 0) };
        GildedRose app = updateQuality(items);
        assertEquals(sellIn-1, app.items[0].sellIn);
    }

    @Test
    public void agedBrieZeroQuality_QualityIncreaseByOne() {
        int quality = 0;
        Item[] items = new Item[] { new Item("Aged Brie", 5, quality) };
        GildedRose app = updateQuality(items);
        assertEquals(quality+1, app.items[0].quality);
    }

}
