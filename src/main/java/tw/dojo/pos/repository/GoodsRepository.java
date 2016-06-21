package tw.dojo.pos.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import tw.dojo.pos.domain.Goods;

@Repository
public class GoodsRepository {
    private static final Map<String, Goods> goodsMapper = new HashMap<>();

    public Goods findOne(String barcode) {
        return goodsMapper.get(barcode);
    }

    public Goods save(Goods goods) {
        return goodsMapper.put(goods.getBarcode(), goods);
    }
}
