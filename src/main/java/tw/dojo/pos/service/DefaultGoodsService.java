package tw.dojo.pos.service;

import static org.springframework.util.Assert.notNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.dojo.pos.domain.Goods;
import tw.dojo.pos.repository.GoodsRepository;

@Service
public class DefaultGoodsService implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods saveGoods(Goods goods) {
        notNull(goods, "Goods should not be null");
        notNull(goods.getBarcode(), "Barcode should not be null");
        return goodsRepository.save(goods);
    }
}
