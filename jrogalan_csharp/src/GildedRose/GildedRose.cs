using System.Collections.Generic;
using GildedRose.Core.Extensions;
using GildedRose.Entities;
using GildedRose.Policies;
using Genesis.Ensure;

namespace GildedRose
{
    public class GildedRose
    {
        readonly IPolicyFactory _factory;
        readonly IList<Item> _items;
        
        public GildedRose(IList<Item> items)
        {
            Ensure.ArgumentNotNull(items, nameof(items));

            _items = items;
            _factory = new PolicyFactory();
        }

        public void UpdateQuality() => 
            _items.ForEach(item => 
                _factory.Create(item).UpdateQuality());
    }
}