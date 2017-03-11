using NUnit.Framework;
using GildedRose.Tests.Core.Extensions;
using FluentAssertions;
using GildedRose;
using GildedRose.Entities;
using GildedRose.Policies;
using System.Collections.Generic;
using static GildedRose.Policies.PolicyNames;
using static GildedRose.Tests.Core.Hosts.GildedRoseTestHost;

namespace GildedRose.Tests
{
    public class GildedRoseTests
    {
        const string STANDARD = "+ 5 Dexterity Vest";

        [Test]
        public void Should_decrease_standard_item_quality_by_one_after_each_day() =>
            CreateGildedRose(new Item(STANDARD, 2, 5))
                .AfterEachDayUpdate(1)
                .ItemQualityShouldBe(4);
        
        [Test]
        public void Should_decrease_normal_item_sellin_by_one_after_one_day() =>
            CreateGildedRose(new Item(STANDARD, 5, 5))
                .AfterEachDayUpdate(1)
                .ItemSellInShouldBe(4);

        [Test]
        public void Should_decrease_standard_quality_by_two_after_each_day_after_sellin_day() =>
             CreateGildedRose(new Item(STANDARD, 0, 8))
                .AfterEachDayUpdate(3)
                .ItemQualityShouldBe(2);        

        [Test]
        public void Should_not_have_negative_quality() =>
            CreateGildedRose(new Item(STANDARD, 0, 0))
                .AfterEachDayUpdate(2)
                .ItemQualityShouldBe(0);      

        [Test]
        public void Should_increase_aged_brie_quality_by_one_after_each_day_before_sellin_day() =>
            CreateGildedRose(new Item(AGED_BRIE, 15, 5))
                .AfterEachDayUpdate(3)
                .ItemQualityShouldBe(8);      
        
        [Test]
        public void Should_increase_aged_brie_quality_by_two_after_each_day_after_sellin_day() =>
            CreateGildedRose(new Item(AGED_BRIE, 0, 5))
                .AfterEachDayUpdate(3)
                .ItemQualityShouldBe(11); // (3 * 2) + 5      
        
        [Test]
        public void Should_not_increase_quality_more_than_fifty() =>
            CreateGildedRose(new Item(AGED_BRIE, 0, 5))
                .AfterEachDayUpdate(100)
                .ItemQualityShouldBe(50);    

        [Test]     
        public void Should_keep_sulfurast_inmutable() =>
            CreateGildedRose(new Item(SULFURAS, 0, 80))
                .AfterEachDayUpdate(10)
                .ItemQualityShouldBe(80)
                .ItemSellInShouldBe(0);    

        [Test]
        public void Should_increase_backstage_quality_by_one_after_each_day_before_ten_days_sell_in_day() =>
            CreateGildedRose(new Item(BACKSTAGE_PASSES, 13, 10))
                .AfterEachDayUpdate(3)
                .ItemQualityShouldBe(13); // (3 * 1) + 10         

        [Test]
        public void Should_increase_backstage_quality_by_two_after_each_day_between_ten_and_five_days_before_sell_in_day() =>
            CreateGildedRose(new Item(BACKSTAGE_PASSES, 10, 10))
                .AfterEachDayUpdate(3)
                .ItemQualityShouldBe(16); // (3 * 2) + 10             

        [Test]
        public void should_increase_backstage_quality_by_three_after_each_day_between_five_and_one_day_before_sell_in_day() =>
            CreateGildedRose(new Item(BACKSTAGE_PASSES, 3, 10))
                .AfterEachDayUpdate(3)
                .ItemQualityShouldBe(19); // (3 * 3) + 10

        [Test]        
        public void should_drop_backstage_passes_quality_to_zero_after_sellin_day() =>
            CreateGildedRose(new Item(BACKSTAGE_PASSES, 0, 10))
                .AfterEachDayUpdate(5)
                .ItemQualityShouldBe(0);    

        [Test]
        public void should_decrease_conjured_quality_by_two_after_each_day() => 
            CreateGildedRose(new Item(CONJURED, 10, 10))
                .AfterEachDayUpdate(3)
                .ItemQualityShouldBe(4); // 10 - (3 * 2)   

        [Test]
        public void should_decrease_conjured_sellin_by_four_after_each_after_sellin_day() =>
            CreateGildedRose(new Item(CONJURED, 0, 12))
                .AfterEachDayUpdate(2)
                .ItemQualityShouldBe(4); // 12 - (2 * 4)
    }
}