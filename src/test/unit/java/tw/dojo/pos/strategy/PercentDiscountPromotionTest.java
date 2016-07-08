package tw.dojo.pos.strategy;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import tw.dojo.pos.domain.Goods;
import tw.dojo.pos.domain.PercentDiscount;
import tw.dojo.pos.domain.ShoppingItem;
import tw.dojo.pos.repository.PercentDiscountRepository;

public class PercentDiscountPromotionTest {

    private static final String BARCODE = "123456";
    @InjectMocks
    private PercentDiscountPromotion promotionService;

    @Mock
    private PercentDiscountRepository promotionRepository;
    private Goods goods;

    @Before
    public void setUp() {
        initMocks(this);
        goods = new Goods(BARCODE);
        goods.setPrice(3.0);
    }

    @Test
    public void should_calculate_percent_discount_benefit() {
        ShoppingItem item = new ShoppingItem(BARCODE, 3);
        item.setGoods(goods);
        when(promotionRepository.findOne(BARCODE)).thenReturn(new PercentDiscount(95));

        Double benefit = promotionService.calculateBenefit(item);

        assertThat(benefit, closeTo(0.45, 0.000001));
    }

    @Test
    public void should_discount_benefit_be_zero_if_goods_is_not_in_promotion() {
        ShoppingItem item = new ShoppingItem(BARCODE, 3);
        item.setGoods(goods);
        when(promotionRepository.findOne(BARCODE)).thenReturn(null);

        Double benefit = promotionService.calculateBenefit(item);

        assertThat(benefit, closeTo(0.0, 0.000001));
    }
}
