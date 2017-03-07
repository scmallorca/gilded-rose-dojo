package com.gildedrose;

class GildedRose {

    private final Item[] items;

    public GildedRose(final Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final ItemType itemType = ItemType.getBy(item.name);
            final InnItem innItem = itemType.create(item);
            innItem.updateQuality();
        }
    }

}