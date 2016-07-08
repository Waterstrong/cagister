package tw.dojo.pos.domain;

public class ShoppingItem {
    private String barcode;
    private Integer amount;
    private Double benefit;
    private Goods goods;

    public ShoppingItem(String barcode, Integer amount) {
        this.barcode = barcode;
        this.amount = amount;
        benefit = 0d;
        goods = null;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public Double getBenefit() {
        return benefit;
    }

    public Double calculateSubtotal() {
        return calculateTotal() - getBenefit();
    }

    public Double calculateTotal() {
        return goods.getPrice() * getAmount();
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return goods.getName();
    }

    public String getUnit() {
        return goods.getUnit();
    }

    public Double getPrice() {
        return goods.getPrice();
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goods getGoods() {
        return goods;
    }
}
