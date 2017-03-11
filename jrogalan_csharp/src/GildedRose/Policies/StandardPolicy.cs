using GildedRose.Entities;

namespace GildedRose.Policies
{
    public class StandardPolicy : BasePolicy, IPolicy
    {
        public StandardPolicy(Item item) : base(item) {}
        
        public void UpdateQuality()
        {
            DecreaseQuality();
            DecreaseSellIn();
            if (IsAfterSellIn())
                DecreaseQuality();
        }
    }
}