using GildedRose.Entities;

namespace GildedRose.Policies
{
    public class ConjuredPolicy : BasePolicy, IPolicy
    {
        public ConjuredPolicy(Item item) : base(item) {}

        public void UpdateQuality()
        {
            DecreaseQualityTwice();
            DecreaseSellIn();
            if (IsAfterSellIn())
                DecreaseQualityTwice();
        }
    }
}