using System;
using System.Collections.Generic;
using GildedRose.Entities;
using static GildedRose.Policies.PolicyNames;

namespace GildedRose.Policies
{
    public class PolicyContainer : IPolicyContainer
    { 
        readonly IDictionary<string, Func<Item, IPolicy>> _policies;

        Func<Item, IPolicy> _default;

        public PolicyContainer()
        {
            _policies = new Dictionary<string, Func<Item, IPolicy>>();
            SetPolicies();
        }

        void SetPolicies()
        {
            _default                    = (item) => new StandardPolicy(item);
            _policies[SULFURAS]         = (item) => new SulfurasPolicy(item);
            _policies[AGED_BRIE]        = (item) => new AgedBriePolicy(item);
            _policies[BACKSTAGE_PASSES] = (item) => new BackStagePassPolicy(item);
            _policies[CONJURED]         = (item) => new ConjuredPolicy(item);
        }

        public Func<Item, IPolicy> GetBuilder(string name) => 
            _policies.ContainsKey(name) 
                ? _policies[name] : _default;
    }
}