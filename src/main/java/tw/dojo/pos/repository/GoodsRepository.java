package tw.dojo.pos.repository;

import org.springframework.stereotype.Repository;

import tw.dojo.pos.domain.Goods;

@Repository
public class GoodsRepository {
    public Goods findOne(String barcode) {
        return null;
    }
}
