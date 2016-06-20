package tw.dojo.pos.repository;

import java.util.HashMap;
import java.util.Map;

import tw.dojo.pos.domain.PercentDiscount;

public class PercentDiscountRepository {
    private static final Map<String, PercentDiscount> promotionMapper = new HashMap<>();

    public PercentDiscount findOne(String barcode) {
        return promotionMapper.get(barcode);
    }

}
