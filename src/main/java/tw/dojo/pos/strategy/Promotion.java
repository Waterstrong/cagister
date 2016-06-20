package tw.dojo.pos.strategy;

import tw.dojo.pos.domain.Item;

public interface Promotion {
    Double calculateBenefit(final Item item);
}
