using GildedRose.Entities;

namespace GildedRose.Policies
{
    public class AgedBriePolicy : BasePolicy, IPolicy
    {
        public AgedBriePolicy(Item item) : base(item) {}

        public void UpdateQuality()
        {
            IncreaseQuality();
            DecreaseSellIn();
            if (IsAfterSellIn())
                IncreaseQuality();
        }
    }
}