using GildedRose.Entities;

namespace GildedRose.Policies
{
    public interface IPolicyFactory
    {
        IPolicy Create(Item item);
    }
}