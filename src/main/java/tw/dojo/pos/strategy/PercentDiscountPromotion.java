package tw.dojo.pos.strategy;

import static java.util.Optional.ofNullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.dojo.pos.domain.Item;
import tw.dojo.pos.domain.PercentDiscount;
import tw.dojo.pos.repository.PercentDiscountRepository;

@Component
public class PercentDiscountPromotion implements IPromotion {

    private static final int HUNDRED = 100;

    @Autowired
    private PercentDiscountRepository promotionRepository;

    @Override
    public Double calculateBenefit(Item item) {
        PercentDiscount percentDiscount =
                ofNullable(promotionRepository.findOne(item.getBarcode()))
                .orElse(new PercentDiscount(HUNDRED));
        return item.calculateTotal() * (HUNDRED - percentDiscount.getRate()) * 0.01;
    }
}
