package tw.dojo.pos.domain;

public class Item {
    private String barcode;
    private Integer amount;

    public Item(String barcode, Integer amount) {
        this.barcode = barcode;
        this.amount = amount;
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getAmount() {
        return amount;
    }
}
