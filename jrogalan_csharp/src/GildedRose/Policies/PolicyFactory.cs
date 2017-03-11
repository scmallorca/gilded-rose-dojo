using Genesis.Ensure;
using GildedRose.Entities;

namespace GildedRose.Policies
{
    public class PolicyFactory : IPolicyFactory
    {
        readonly IPolicyContainer _container;

        public PolicyFactory()
        {   
            _container = new PolicyContainer();    
        }
        
        public IPolicy Create(Item item) 
        {
            Ensure.ArgumentNotNull(item, nameof(item));

            return _container.GetBuilder(item.Name)(item);
        }
    }
}