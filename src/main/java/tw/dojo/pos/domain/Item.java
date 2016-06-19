package tw.dojo.pos.domain;

public class Item {
    private String barcode;
    private Integer amount;
    private Double price;
    private String name;
    private String unit;
    private Double benefit;

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

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public Double getPrice() {
        return price;
    }

    public Double getBenefit() {
        return benefit;
    }
}
