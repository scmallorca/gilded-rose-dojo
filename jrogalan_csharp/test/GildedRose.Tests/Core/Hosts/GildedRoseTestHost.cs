using System.Collections.Generic;
using GildedRose;
using GildedRose.Entities;

namespace GildedRose.Tests.Core.Hosts
{
    public class GildedRoseTestHost
    {
        protected GildedRoseTestHost(Item item) 
        {
            this.FirstItem = item;
            this.GildedRose = new GildedRose(new List<Item> { item });
        }

        public GildedRose GildedRose { get; protected set; }
        public Item FirstItem { get; protected set; }
        
        public static GildedRoseTestHost CreateGildedRose(Item item) => new GildedRoseTestHost(item);
    }
}