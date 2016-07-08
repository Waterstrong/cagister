package tw.dojo.pos.strategy;

import tw.dojo.pos.domain.ShoppingItem;

public interface IPromotion {
    Double calculateBenefit(final ShoppingItem item);
}
