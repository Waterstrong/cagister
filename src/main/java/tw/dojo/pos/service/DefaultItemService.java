package tw.dojo.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.dojo.pos.domain.ShoppingItem;
import tw.dojo.pos.repository.GoodsRepository;
import tw.dojo.pos.strategy.IPromotion;

@Service
public class DefaultItemService implements ItemService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private IPromotion promotion;

    @Override
    public List<ShoppingItem> calculateItems(final List<ShoppingItem> items) {
        items.stream().forEach(item -> calculate(item));
        return items;
    }

    private void calculate(final ShoppingItem item) {
        String barcode = item.getBarcode();
        item.setGoods(goodsRepository.findOne(barcode));
        item.setBenefit(promotion.calculateBenefit(item));
    }
}
