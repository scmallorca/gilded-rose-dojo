package com.gildedrose;

import java.util.stream.Stream;

/**
 * Created by jllado on 6/03/17.
 */
public enum ItemType implements ItemFactory{

    AGED_BRIE("Aged Brie") {
        @Override
        public InnItem create(final Item item) {
            return new AgedBrie(item);
        }
    },
    SULFURAS("Sulfuras, Hand of Ragnaros") {
        @Override
        public InnItem create(final Item item) {
            return new Sulfuras();
        }
    },
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert") {
        @Override
        public InnItem create(final Item item) {
            return new Backstage(item);
        }
    },
    CONJURED("Conjured") {
        @Override
        public InnItem create(final Item item) {
            return new Conjured(item);
        }
    },
    NORMAL("Normal") {
        @Override
        public InnItem create(final Item item) {
            return new Normal(item);
        }
    };

    private final String name;

    ItemType(final String name) {
        this.name = name;
    }

    public static ItemType getBy(final String name) {
        return Stream.of(values()).filter(type -> name.equals(type.getName())).findFirst().orElse(NORMAL);
    }

    public String getName() {
        return name;
    }
}
