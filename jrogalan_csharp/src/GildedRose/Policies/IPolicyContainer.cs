using System;
using GildedRose.Entities;

namespace GildedRose.Policies
{
    public interface IPolicyContainer
    {
        Func<Item, IPolicy> GetBuilder(string name);
    }
}