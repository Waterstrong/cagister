package tw.dojo.pos.domain;

import java.util.List;

public class Receipt {
    private List<ShoppingItem> items;

    public Receipt(List<ShoppingItem> items) {
        this.items = items;
    }

    public List<ShoppingItem> getItems() {
        return items;
    }
}
