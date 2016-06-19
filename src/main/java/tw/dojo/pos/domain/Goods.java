package tw.dojo.pos.domain;

public class Goods {
    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String subCategory;
    private Double price;

    public Goods(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }
}
