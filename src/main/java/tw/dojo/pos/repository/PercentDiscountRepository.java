package tw.dojo.pos.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import tw.dojo.pos.domain.PercentDiscount;

@Repository
public class PercentDiscountRepository {
    private static final Map<String, PercentDiscount> promotionMapper = new HashMap<>();

    public PercentDiscount findOne(String barcode) {
        return promotionMapper.get(barcode);
    }

}
