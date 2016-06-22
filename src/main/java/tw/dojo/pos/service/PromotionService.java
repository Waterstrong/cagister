package tw.dojo.pos.service;

public interface PromotionService {
    void createPercentDiscount(String barcode, Integer rate);
}
