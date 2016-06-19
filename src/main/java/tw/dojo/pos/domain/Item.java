package tw.dojo.pos.domain;

public class Item extends Goods {
    private Integer amount;
    private Double benefit;

    public Item(String barcode, Integer amount) {
        super(barcode);
        this.amount = amount;
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

    public Double getSubtotal() {
        return getPrice() * getAmount() - getBenefit();
    }
}
