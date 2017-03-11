using static System.Console;
using GildedRose;
using GildedRose.Entities;
using System.Collections.Generic;
using GildedRose.Console.Core.Extensions;
using System;

namespace GildedRose.Console
{
    public class Program
    {
        public static List<Item> GetInventory() =>
            new List<Item>
            {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)

            };    
        
        static public int DisplayMenu()
		{         
			WriteLine("GildedRose");
			WriteLine();
			WriteLine(". Enter days");					
			var result = ReadLine();
			return Convert.ToInt32(result);
		}

        public static void Main(string[] args)
        {                
            var items = GetInventory();
            var app = new GildedRose(items);        
            int days = 1;
			do
			{
				days = DisplayMenu();
				if (days > 0)
                {
                    items.Print();
                    for (int i = 1; i <= days; i++)
                    {  
                        WriteLine($"-------- day {i} --------");                                                
                        app.UpdateQuality();
                        items.Print();
                    }                    
                }
			} while (true);        
            // ReadKey();
        }
    }
}