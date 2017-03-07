package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GildedRoseTest {

    @Test
    public void should_decrease_quality_twice_when_sell_date_has_passed_given_any_item() throws Exception {
        final Item anyItem = new Item("whatever", 0, 4);
        final GildedRose app = createGildedRoseWith(anyItem);

        app.updateQuality();

        assertThat(anyItem.quality, is(2));
    }

    @Test
    public void should_decrease_sellin_always() throws Exception {
        final Item anyItem = new Item("whatever", 1, 4);
        final Item fiftyQualityItem = new Item("whatever", 1, 50);
        final Item agedBrie = new Item("Aged Brie", 1, 30);
        final Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30);
        final Item conjured = new Item("Conjured", 1, 30);
        final GildedRose app = createGildedRoseWith(anyItem, fiftyQualityItem, agedBrie, backstage, conjured);

        app.updateQuality();

        assertThat(fiftyQualityItem.sellIn, is(0));
        assertThat(anyItem.sellIn, is(0));
        assertThat(agedBrie.sellIn, is(0));
        assertThat(backstage.sellIn, is(0));
    }

    @Test
    public void quality_should_never_be_negative() throws Exception {
        final Item sellDateHasPassedAndZeroQualityItem = new Item("whatever", 0, 0);
        final Item sellDateHasPassedAndOneQualityItem = new Item("whatever", 0, 1);
        final Item sellInToOneAndZeroQualityItem = new Item("whatever", 1, 0);
        final GildedRose app = createGildedRoseWith(sellDateHasPassedAndZeroQualityItem,
                sellInToOneAndZeroQualityItem, sellDateHasPassedAndOneQualityItem);

        app.updateQuality();

        assertThat(sellDateHasPassedAndZeroQualityItem.quality, is(0));
        assertThat(sellInToOneAndZeroQualityItem.quality, is(0));
        assertThat(sellDateHasPassedAndOneQualityItem.quality, is(0));
    }

    @Test
    public void should_increase_quality_by_one_given_aged_brie_when_one_day_has_passed() throws Exception {
        final int sellDateNotPassed = 2;
        final Item agedBrie = new Item("Aged Brie", sellDateNotPassed, 1);
        final GildedRose app = new GildedRose(new Item[] {agedBrie});

        app.updateQuality();

        assertThat(agedBrie.quality, is(2));
    }


    @Test
    public void should_increase_quality_by_two_given_aged_brie_when_sell_date_has_passed() throws Exception {
        final int sellDatePassed = 0;
        final Item agedBrie = new Item("Aged Brie", sellDatePassed, 1);
        final GildedRose app = createGildedRoseWith(agedBrie);

        app.updateQuality();

        assertThat(agedBrie.quality, is(3));
    }


    @Test
    public void quality_should_never_be_superior_to_fifty() throws Exception {
        final Item sellDateNotPassedAgedBrie = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
        final Item sellDatePassedAgedBrie = new Item("Aged Brie", 0, 49);
        final GildedRose app = createGildedRoseWith(sellDateNotPassedAgedBrie, sellDatePassedAgedBrie);

        app.updateQuality();

        assertThat(sellDatePassedAgedBrie.quality, is(50));
        assertThat(sellDateNotPassedAgedBrie.quality, is(50));
    }


    @Test
    public void sulfuras_should_be_immutable() throws Exception {
        final Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 4, 30);
        final GildedRose app = createGildedRoseWith(sulfuras);

        app.updateQuality();

        assertThat(sulfuras.quality, is(30));
        assertThat(sulfuras.sellIn, is(4));
    }

    @Test
    public void should_increase_quality_by_two_given_backstage_when_sellin_is_ten_or_less() throws Exception {
        final Item sellInToTenBackstage = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3);
        final Item sellInToNineBackstage = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 3);
        final GildedRose app = createGildedRoseWith(sellInToTenBackstage, sellInToNineBackstage);

        app.updateQuality();

        assertThat(sellInToTenBackstage.quality, is(5));
    }

    @Test
    public void should_increase_quality_by_three_given_backstage_when_sellin_is_five_or_less() throws Exception {
        final Item sellInToFiveBackstage = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 3);
        final Item sellInToFourBackstage = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 3);
        final GildedRose app = createGildedRoseWith(sellInToFiveBackstage, sellInToFourBackstage);

        app.updateQuality();

        assertThat(sellInToFiveBackstage.quality, is(6));
    }

    @Test
    public void should_decrease_quality_to_zero_given_backstage_when_sell_date_has_passed() throws Exception {
        final Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);
        final GildedRose app = createGildedRoseWith(backstage);

        app.updateQuality();

        assertThat(backstage.quality, is(0));
    }

    @Test
    public void should_decrease_quality_by_two_given_conjured() throws Exception {
        final Item sellDateNotPassedConjured = new Item("Conjured", 10, 5);
        final Item sellDatePassedConjured = new Item("Conjured", 0, 5);
        final GildedRose app = createGildedRoseWith(sellDateNotPassedConjured, sellDatePassedConjured);

        app.updateQuality();

        assertThat(sellDateNotPassedConjured.quality, is(3));
        assertThat(sellDatePassedConjured.quality, is(1));
    }

    private GildedRose createGildedRoseWith(final Item... item) {
        return new GildedRose(item);
    }

}
