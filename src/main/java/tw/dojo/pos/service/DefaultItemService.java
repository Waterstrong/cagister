package tw.dojo.pos.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.dojo.pos.domain.Goods;
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
    public List<ShoppingItem> calculateItems(List<ShoppingItem> items) {
        return items.stream().map(item -> calculate(item)).collect(toList());
    }

    private ShoppingItem calculate(final ShoppingItem item) {
        String barcode = item.getBarcode();
        Goods goods = goodsRepository.findOne(barcode);
        ShoppingItem calculatedItem = new ShoppingItem(barcode, item.getAmount());
        calculatedItem.setGoods(goods);
        calculatedItem.setBenefit(promotion.calculateBenefit(calculatedItem));
        return calculatedItem;
    }
}
