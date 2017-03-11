using FluentAssertions;
using GildedRose.Entities;
using GildedRose;
using GildedRose.Tests.Core.Hosts;

namespace GildedRose.Tests.Core.Extensions
{
    public static class GilderRoseTestExtensions
    {
        public static GildedRoseTestHost AfterEachDayUpdate(this GildedRoseTestHost source, int numberOfDays)
        {
            for (int i = 0; i < numberOfDays; i++)
                source.GildedRose.UpdateQuality();
            return source;
        }

        public static GildedRoseTestHost ItemQualityShouldBe(this GildedRoseTestHost source, int expected)
        { 
            source.FirstItem.Quality.Should().Be(expected);
            return source;
        }

        public static GildedRoseTestHost ItemSellInShouldBe(this GildedRoseTestHost source, int expected)
        {
            source.FirstItem.SellIn.Should().Be(expected);
            return source;
        }
    }
}