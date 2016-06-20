package tw.dojo.pos.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import tw.dojo.pos.domain.Item;
import tw.dojo.pos.domain.PercentDiscount;
import tw.dojo.pos.repository.PercentDiscountRepository;

public class PercentDiscountPromotion implements IPromotion {

    @Autowired
    private PercentDiscountRepository promotionRepository;

    @Override
    public Double calculateBenefit(Item item) {
        PercentDiscount percentDiscount = promotionRepository.findOne(item.getBarcode());
        return item.calculateTotal() * (100 - percentDiscount.getRate()) * 0.01;
    }
}
