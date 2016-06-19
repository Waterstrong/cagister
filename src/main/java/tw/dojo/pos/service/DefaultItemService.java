package tw.dojo.pos.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.dojo.pos.domain.Item;
import tw.dojo.pos.entity.Goods;
import tw.dojo.pos.repository.ItemRepository;

@Service
public class DefaultItemService implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> calculateItems(List<Item> items) {
        return items.stream().map(item -> calculate(item)).collect(toList());
    }

    private Item calculate(final Item item) {
        String barcode = item.getBarcode();
        Goods goods = itemRepository.findOne(barcode);
        Item calculatedItem = new Item(barcode, item.getAmount());
        calculatedItem.setPrice(goods.getPrice());
        calculatedItem.setName(goods.getName());
        calculatedItem.setUnit(goods.getUnit());
        calculatedItem.setBenefit(0.0);
        return calculatedItem;
    }
}
