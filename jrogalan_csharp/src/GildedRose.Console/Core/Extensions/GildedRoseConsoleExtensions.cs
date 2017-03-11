using System.Collections.Generic;
using static System.Console;
using GildedRose;
using GildedRose.Entities;

namespace GildedRose.Console.Core.Extensions
{
    public static class GildedRoseConsoleExtensions
    {
        public static void Print(this IEnumerable<Item> items)
        {
            foreach(var item in items)
                WriteLine(item.ToString());
        }
    }
}