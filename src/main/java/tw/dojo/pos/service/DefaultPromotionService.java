package tw.dojo.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.dojo.pos.domain.PercentDiscount;
import tw.dojo.pos.repository.PercentDiscountRepository;

@Service
public class DefaultPromotionService implements PromotionService {

    @Autowired
    private PercentDiscountRepository percentDiscountRepository;

    @Override
    public void createPercentDiscount(String barcode, Integer rate) {
        PercentDiscount percentDiscount = new PercentDiscount(barcode, rate);
        percentDiscountRepository.save(percentDiscount);
    }
}
