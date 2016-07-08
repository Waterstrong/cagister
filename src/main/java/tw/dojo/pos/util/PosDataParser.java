package tw.dojo.pos.util;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import tw.dojo.pos.domain.ShoppingItem;

public class PosDataParser {

    private static final String SPLIT_CHAR = "-";
    private static final int DEFAULT_AMOUNT = 1;

    public static List<ShoppingItem> parse(List<String> inputs) {
        List<ShoppingItem> items = inputs.stream().map(input -> splitOutItem(input)).collect(toList());
        return mergeItems(items);
    }

    private static List<ShoppingItem> mergeItems(List<ShoppingItem> items) {
        Map<String, Integer> itemMapper = new LinkedHashMap<>();
        items.stream().forEach(item -> {
            String barcode = item.getBarcode();
            Integer nextAmount = itemMapper.get(barcode);
            nextAmount = (nextAmount == null) ? 0 : nextAmount;
            itemMapper.put(barcode, item.getAmount() + nextAmount);
        });
        return itemMapper.keySet().stream()
                .map(key -> new ShoppingItem(key, itemMapper.get(key)))
                .collect(toList());
    }

    private static ShoppingItem splitOutItem(String input) {
        String[] result = input.split(SPLIT_CHAR);
        return new ShoppingItem(result[0], (result.length == 2) ? parseInt(result[1]) : DEFAULT_AMOUNT);
    }
}
