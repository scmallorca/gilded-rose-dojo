package com.gildedrose;

class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            items[i] = ItemFactory.createItem(items[i]).updateItem();
        }
    }
}