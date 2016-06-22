package tw.dojo.pos.domain;

public class PercentDiscount {
    private String barcode;
    private Integer rate;

    public PercentDiscount(Integer rate) {
        this.rate = rate;
    }

    public PercentDiscount(String barcode, Integer rate) {
        this.barcode = barcode;
        this.rate = rate;
    }

    public Integer getRate() {
        return rate;
    }

    public String getBarcode() {
        return barcode;
    }
}
