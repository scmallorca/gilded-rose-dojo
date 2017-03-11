using GildedRose.Entities;

namespace GildedRose.Policies
{
    public class BackStagePassPolicy : BasePolicy, IPolicy
    {
        const int VERY_CLOSE_SELLIN = 6;
        const int CLOSE_SELLIN = 11;
        
        public BackStagePassPolicy(Item item) : base(item) {}

        bool IsVeryCloseToConcert() => IsSellInLowerThan(VERY_CLOSE_SELLIN);

        bool IsCloseToConcert() => IsSellInLowerThan(CLOSE_SELLIN);

        public void UpdateQuality()
        {
            IncreaseQuality();
            if (IsCloseToConcert())
                IncreaseQuality();
            if (IsVeryCloseToConcert())
                IncreaseQuality();
            DecreaseSellIn();
            if (IsAfterSellIn())
                DropQuality();
        }
    }
}