package tw.dojo.pos.strategy;

import tw.dojo.pos.domain.Item;

public interface IPromotion {
    Double calculateBenefit(final Item item);
}
