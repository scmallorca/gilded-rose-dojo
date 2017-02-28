package com.gildedrose;

class GildedRose {

    private enum ItemType {
        SULFURAS("Sulfuras, Hand of Ragnaros"),
        BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
        AGED_BRIE("Aged Brie"),
        CONJURED("Conjured Mana Cake"),
        NORMAL("");

        private String name;

        ItemType(String name) {
            this.name = name;
        }

        public static ItemType get(String name) {
            for (ItemType itemType : values()) {
                if (name.equals(itemType.name)) {
                    return itemType;
                }
            }
            return NORMAL;
        }
    }

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            final InnItem innItem = createInnItem(item.name);
            innItem.update(item);
        }
    }

    private InnItem createInnItem(String name) {
        final ItemType itemType = ItemType.get(name);
        if (ItemType.SULFURAS == itemType) {
            return new Sulfuras();
        } else if (ItemType.BACKSTAGE == itemType) {
            return new Backstage();
        } else if (ItemType.AGED_BRIE == itemType) {
            return new AgedBrie();
        } else if (ItemType.CONJURED == itemType) {
            return new Conjured();
        }
        return new Normal();
    }
}

