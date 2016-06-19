package tw.dojo.pos.service;

import java.util.List;

import tw.dojo.pos.domain.Item;

public interface ItemService {
    List<Item> calculateItems(List<Item> items);
}
