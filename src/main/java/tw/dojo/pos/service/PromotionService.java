package tw.dojo.pos.service;

import tw.dojo.pos.domain.Item;

public interface PromotionService {
    Double calculateBenefit(final Item item);
}
