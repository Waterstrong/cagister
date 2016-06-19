package tw.dojo.pos.repository;

import org.springframework.stereotype.Repository;

import tw.dojo.pos.entity.Goods;

@Repository
public class ItemRepository {
    public Goods findOne(String barcode) {
        return null;
    }
}
