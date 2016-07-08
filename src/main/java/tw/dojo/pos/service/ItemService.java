package tw.dojo.pos.service;

import java.util.List;

import tw.dojo.pos.domain.ShoppingItem;

public interface ItemService {
    List<ShoppingItem> calculateItems(List<ShoppingItem> items);
}
