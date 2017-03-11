using GildedRose.Entities;

namespace GildedRose.Policies
{
    public class SulfurasPolicy : BasePolicy, IPolicy
    {
        public SulfurasPolicy(Item item) : base(item) {}
        
        public void UpdateQuality() {}
    }
}