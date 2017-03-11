using GildedRose.Entities;

namespace GildedRose.Policies
{
    public abstract class BasePolicy
    {
        public const int MIN_QUALITY = 0;
        public const int MAX_QUALITY = 50;
        public const int UNIT_VALUE = 1;
        
        protected Item _item;

        public BasePolicy(Item item)
        {
            _item = item;
        }
        
        bool IsQualityBelowMax() => _item.Quality < MAX_QUALITY;

        bool IsQualityOverMin() => _item.Quality > MIN_QUALITY;
        
        protected bool IsAfterSellIn() => IsSellInLowerThan(MIN_QUALITY);

        protected bool IsSellInLowerThan(int value) => _item.SellIn < value;

        protected void DecreaseSellIn() => _item.SellIn -= UNIT_VALUE;

        protected void DropQuality() => _item.Quality = MIN_QUALITY;

        protected void DecreaseQuality()
        {
            if (IsQualityOverMin())
                _item.Quality -= UNIT_VALUE;
        }

        protected void IncreaseQuality()
        {
            if (IsQualityBelowMax())
                _item.Quality += UNIT_VALUE;
        }

        protected void DecreaseQualityTwice()
        {
            DecreaseQuality();
            DecreaseQuality();    
        }
    }
}